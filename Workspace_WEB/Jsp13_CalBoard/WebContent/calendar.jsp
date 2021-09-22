<%@page import="com.cal.dto.CalDto"%>
<%@page import="java.util.List"%>
<%@page import="com.cal.dao.CalDao"%>
<%@page import="com.cal.common.Util"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	#calendar {/*: td th  전체적인 속성 값이 사라지고, table border속성이 사라져, 전체적으로 통합된 형태 */
		border-collapse: collapse;
		border: 1px solid pray;
	}
	#calendar th{
		width : 80px;
		border: 1px solid gray;
	}
	#calendar td{
		width: 80px;
		height: 80px;
		border: 1px solid gray;
		text-align: left;
		vertical-align: top;
		position: relative;
	}
	a{
		text-decoration: none;
	}
	
	.list > p {
		font-size: 5px;
		margin: 1px;
		background-color: skyblue;
	}
	
	.preview{
		position: absolute;
		top: -30px;
		left: 10px;
		background-color: skyblue;
		width: 40px;
		height: 40px;
		text-align: center;
		line-height: 40px;
		border-radius: 40px 40px 40px 1px;
	}

</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	function isTwo(n){
		return (n.length<2)? "0"+n: n;
		}
	/*비동기 통신(async) : 정보를 일정한 속도로 보낼 것을 요구하지 않는 데이터 전송 방법이다.*/
	$(function(){
		$(".conutview").hover(function(){
			// handle in
			var countView = $(this);
			var year = $(".y").text().trim();
			var month = $(".m").text().trim();
			var date = countView.text().trim();
			var yyyyMMdd = year + isTwo(month) + isTwo(date);
			
			$.ajax({
				type: "post",
				url: "count.do?id=kh&yyyyMMdd="+yyyyMMdd,
				dataType: "json",
				async: false,
				success: function(msg){
					var count = msg.calcount;
					countView.after("<div class='preview'>"+count+"</div>");
				},
				error: function(){
					alert("통신 실패");
				}
			});
			
		},
		function(){
			// hendle out
			$(".preview").remove();
		});
	});

</script>
</head>
<body>
<%	// 현재 시간의 연월일시분초를 가져온다
	// Calendar cal = new Calendar 는 못하는게 private로 만들었기에 못가져온다.
	Calendar cal = Calendar.getInstance(); // 싱글톤 패턴
	// 현재의 year, month에 넣어준다  0~11 리턴해서 +1 
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH) + 1;
	
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	
	if(paramYear != null){
		year = Integer.parseInt(paramYear);
	} 
	if(paramMonth != null){
		month = Integer.parseInt(paramMonth);
	}
	// 12보다 높아지면 년도 1증가하고 1월로바꾼다
	if(month > 12){
		month = 1;
		year++;
	}
	// 1보다 낮아지면 년도를 1 낮추고 12월로바꾼다
	if(month <1){
		month = 12;
		year--;
	}
	// 달력 넘길때마다 새로운 달력을 출력한다.
	cal.set(year, month-1, 1);
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	//달의 27,28 30 31일 중 하나를 넣어준다.
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	
	CalDao dao = new CalDao();
	String yyyyMM = year + Util.isTwo(String.valueOf(month));
	List<CalDto> list = dao.getCalViewList("kh", yyyyMM);
	
	
%>
	<table id="calendar">
		<caption>
			<a href="calendar.jsp?year=<%=year-1%>&month=<%=month%>">◁</a>
			<a href="calendar.jsp?year=<%=year%>&month=<%=month-1%>">◀</a>
			
			<span class="y"><%=year %></span>년
			<span class="m"><%=month %></span>월
			
			<a href="calendar.jsp?year=<%=year%>&month=<%=month+1%>">▶</a>
			<a href="calendar.jsp?year=<%=year+1%>&month=<%=month%>">▷</a>
		</caption>
		
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
		<tr>
			
		</tr>
<%	// 1일 나오기전까지의 공백 dayOfWeek : 1일의 요일 일요일이 1부터 시작해서 -1을 해서 0으로 만들어서 하는것이다.
	for(int i = 0; i < dayOfWeek-1; i++){
		out.print("<td></td>");
	} // 달의 마지막 날까지 숫자출력
	for (int i = 1; i <= lastDay; i++){
%>
		<td>
			<a class="conutview" href="cal.do?command=list&year=<%=year%>&month=<%=month %>&date=<%=i %>" style="color: <%=Util.fontColor(i, dayOfWeek)%>"><%=i %></a>
			<a href="insert.jsp?year=<%=year%>&month=<%=month%>&date=<%=i%>&lastDay=<%=lastDay%>">
				<img alt="" src="image/pen.png" style="width: 10px; height: 10px;">
			</a>
			<div class="list">
				<%=Util.getCalView(i, list) %>
			</div>
		</td>
<%		// 토요일이면 줄바꿈
		if((dayOfWeek-1+i)%7 == 0){
			out.print("<tr></tr>");
		}
	}
	// 마지막날에서 남은일에 공백 7-로 안하면 토요일이 마지막 날이면 밑에 공백이 한줄 생긴다.
	for (int i = 0; i < (7-(dayOfWeek - 1 + lastDay)%7)%7; i++){
		out.print("<td></td>");
	}
	
	
%>
		
		
		
	</table>
	
	
</body>
</html>