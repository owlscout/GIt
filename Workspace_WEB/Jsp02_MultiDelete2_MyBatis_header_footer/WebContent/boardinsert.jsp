<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="boardinsertres.jsp" method="post">
		<h1>글쓰기</h1>
			<table border="2">
				<tr> 
					<th>글쓴이</th>
					<td><input type="text" name="writer"></td>	
				</tr>
				<tr> 
					<th>머릿말</th>
					<td><input type="text" name="title"> </td>	
				</tr>
				<tr> 
					<th>글 내용</th>
					<td><textarea rows="10" cols="60" name="content"></textarea></td>	
				</tr>
				<tr>
					<td colspan="2" align="left">
					<input type="submit" value="완료">
					<input type="button" value="취소" onclick="">
					</td>
				</tr>
			</table>
	</form>

</body>
</html>