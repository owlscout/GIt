<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
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
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	
	function allCheck(bool){
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++){
			chks[i].checked = bool;
		}
	}
	
	$(function(){
		$("#muldelform").submit(function(){
			if($("#muldelform input:checked").length == 0){
				alert("체크하고 눌러주세요");
				return false;
			}
		});
	});
</script>
</head>
<%
	MDBoardBiz biz = new MDBoardBizImpl();
	List<MDBoardDto> list = biz.selectlist();
%>
<body>
	
	<h1>게시판</h1>
	
	<form action="./muldel.jsp" method="post" id="muldelform">
		<table border="1">
			<col width="30px"/>
			<col width="50px"/>
			<col width="100px"/>
			<col width="300px"/>
			<col width="100px"/>
			<tr>
				<th><input type="checkbox" name="all" onclick="allCheck(this.checked);"></th>
				<th>번호</th>
				<th>닉네임</th>
				<th>글 제목</th>
				<th>작성일</th>
			</tr>
<%
	if(list.size() == 0){
%>
			<tr>
				<td colspan="5" align="center">*********첫 글을 작성해 주세요*******</td>
			</tr>
<%
	} else {
		for(MDBoardDto dto : list){
%>
			<tr>
				<th><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"></th>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="boardselect.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
<%
			}
		}
		
%>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="체크한 게시글 삭제" />
					<input type="button" onclick="location.href='boardinsert.jsp'" value="글 쓰기">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>