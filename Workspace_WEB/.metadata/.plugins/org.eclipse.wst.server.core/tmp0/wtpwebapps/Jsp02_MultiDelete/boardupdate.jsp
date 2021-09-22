<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.dao.MDBoardDaoImpl"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
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
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDaoImpl();	
	MDBoardDto dto = dao.selectOne(seq);
%>
<body>

	<h2>글 수정 > <%=dto.getTitle() %></h2>
	<form action="boardupdateres.jsp" method="post">
		<input type="hidden" name="seq" value=<%=dto.getSeq() %>>
		<table border="1">
			<tr>
				<th>닉네임</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td>
					<textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정하기"/>
					<input type="button" value="취소하기" onclick="location.href='boardselect.jsp?seq=<%=dto.getSeq() %>'">
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>