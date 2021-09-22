<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html;charset=UTF-8");%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int seq =Integer.parseInt(request.getParameter("seq"));
	
	MDBoardBiz biz =new MDBoardBizImpl();
	MDBoardDto dto = biz.selectOne(seq);
%>

	<h1>수정</h1>
	<form action="boardupdateres.jsp" method="post" >
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<table border="2">
			<tr>
				<th>글쓴이</th>
				<td><%=dto.getWriter()%></td>
			</tr>
			<tr>
				<th>머리말</th>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td><textarea rows="10" cols="50" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
		 	<tr>
		 		<td colspan="2" align="left">
		 		 <input type="submit" value="수정완료">
		 		 <input type="button" value="취소" onclick="locateion.href='boardselect.jsp?=seq<%=dto.getSeq()%>'"/>
		 		</td>
		 		
		 	</tr>
		</table>
	</form>

</body>
</html>























