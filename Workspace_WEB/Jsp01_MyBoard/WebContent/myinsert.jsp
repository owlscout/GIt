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

	<h1> 글 쓰기 </h1>
	<form action="./myinsert_res.jsp" method="post">
		<table border="1">
			<tr>
				<th>글쓴이</th>	<!-- from사용하면 무조건 name써야한다. key = value라 name을 써야한다고한다... -->
				<td><input type="text" name="mywriter"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mycontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align=right>
					<input type="submit" value="등록하기">
					<input type="button" value="취소" onclick="location.href='./mylist.jsp'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>