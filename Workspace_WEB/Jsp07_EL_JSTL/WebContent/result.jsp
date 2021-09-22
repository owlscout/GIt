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
	<!-- session 범위에 sc라는 이름의 값을 넣어준다. 없으면 새로운 객체를 생성해서 만든다. 있으면 만들어진것을 불러와서 값을 넣어준다. -->
	<jsp:useBean id="sc" class="com.el.dto.Score" scope="session"></jsp:useBean>
	<h1><jsp:getProperty property="name" name="sc"/></h1>
	
	<h1>${sc.name }</h1>
	
	
	
</body>
</html>