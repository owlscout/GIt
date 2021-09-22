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

	<h1>useBean을 통한 객체 생성!</h1>
	<!-- Score sc = new Score(); 랑같다 (useBean) session을 확인해 해당 객체가 
	있는지 없는지 확인후 없으면 만들고 있으면 불러온다 scope를 안넣으면 기본적으로 page로 만듦 -->
	<jsp:useBean id="sc" class="com.el.dto.Score" scope="session"></jsp:useBean>
	
	<!-- sc.setName("홍길동"); -->
	<jsp:setProperty property="name" name="sc" value="홍길동"/>
	<!-- sc.getName(); -->
	<jsp:getProperty property="name" name="sc"/>
	
	<button onclick="location.href='result.jsp'">result</button>
	
</body>
</html>