<%@page import="com.muldel.dto.MDBoardDto"%>
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
</head>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardBiz biz = new MDBoardBizImpl();
	MDBoardDto dto = biz.selectOne(seq);
	
%>
<body>

	<h2>게시판 > <%=dto.getTitle() %></h2>
	
	<table border="1">
		<tr>
			<td>닉네임</td>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<td>글 제목</td>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td>
				<textarea rows="10" cols="60"><%=dto.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<input type="button" value="목록" onclick="location.href='boardlist.jsp'">
				<input type="button" value="수정" onclick="location.href='boardupdate.jsp?seq=<%=dto.getSeq()%>'">
				<input type="button" value="삭제" onclick="location.href='boarddelete.jsp?seq=<%=dto.getSeq()%>'">
			</td>
		</tr>
	</table>
</body>
</html>