<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
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
</head>
<%	
//request 는 무슨 타입인지 모른다. 그래서 object(가장 최상위 타입이라)로 담아버리기때문에 형변환해줘야한다.
// 부모는 자식꺼를 쓸 수 있지만 자식은 부모꺼를 사용 못하기때문에 
// (부모 -> 자식 명시적 형변환 ) (자식 -> 부모 묵시적 형변환)
	List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("list");
%>
<body>
	
	<h1>List</h1>
	
	<table border="1">
		<col width="50px"/>
		<col width="100px"/>
		<col width="300px"/>
		<col width="100px"/>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
<%
	for(MVCBoardDto dto : list){
%>
		<tr>
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="myservlet.do?command=selectone&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
			<td><%=dto.getRegdate() %></td>
		</tr>	
<%
	}
%>		
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='myservlet.do?command=insertform'"/>
			</td>
		</tr>
	</table>
	
</body>
</html>