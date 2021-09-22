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

	<h2>수정 중....</h2>
	<form action="myupdate_res.jsp" method="post">
	<!-- SQL에 seq이 있는데 없기에 myseq를 넣어야한다. 그리고 글의 번호를 보여줄지말지 상관없는데 hidden으로 숨긴거뿐이다. -->
		<input type="hidden" name="myseq" value="<%=dto.getMyseq()%>" />
		<table border="1">
			<tr>
				<th>글쓴이</th>
				<td><%=dto.getMywriter() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" value="<%=dto.getMytitle() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="60" name="mycontent"><%=dto.getMycontent() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정" />
					<input type="button" value="취소" onclick="location.herf='./myselect.jsp?myseq=<%=dto.getMyseq() %>'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>