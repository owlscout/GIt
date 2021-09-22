<%@page import="com.board.dto.BoardDto"%>
<%@page import="com.board.dao.BoardDao"%>
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
	int myseq = Integer.parseInt(request.getParameter("myseq"));
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.selectOne(myseq);
%>
<body>
	<h3> 자유게시판 > <%=dto.getMytitle() %> </h3>
	
	<table border="1">
		<tr>
			<td>글쓴이</td>
			<td><%=dto.getMywriter() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><%=dto.getMytitle() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
			<textarea rows="10" cols="60" readonly="readonly"><%=dto.getMycontent() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><!-- UI/UX 이다 -->
				<input type="button" value="목록" onclick="location.href='./mylist.jsp'" />
				<input type="button" value="수정" onclick="location.href='./myupdate.jsp?myseq=<%=dto.getMyseq() %>'" />
				<input type="button" value="삭제" onclick="location.href='./mydelete.jsp?myseq=<%=dto.getMyseq() %>'" />
			</td>
		</tr>
	</table>

</body>
</html>