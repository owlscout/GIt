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
	
	<h1>Hello Spring!</h1>
	<br>
	<h2>로그인 실패!!</h2>
	
	<script type="text/javascript">
		setTimeout("location.href='index.jsp'",3000);
	</script>
	
</body>
</html>