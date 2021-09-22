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
<body>

	<h2>글 쓰기</h2>
	<form action="boardinsertres.jsp" method="post">
		<table border="1">
			<tr>
				<th>닉네임</th>
				<td>
					<input type="text" name="writer">
				</td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td>
					<input type="text" name="title">
				</td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td>
					<textarea rows="10" cols="60" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="글 완성">
					<input type="button" value="글 취소" onclick="location.href='boardlist.jsp'">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>