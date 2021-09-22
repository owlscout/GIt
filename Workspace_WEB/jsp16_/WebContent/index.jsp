<%@page import="com.ncs.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<% 
response.setHeader("pragma", "no-cache"); 
response.setHeader("Cache-control", "no-store");
response.setHeader("Expires", "0"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Member dto = (Member)session.getAttribute("Member"); %> 

	<h1>Hello Spring!</h1>
	<div>
		<form action="login.do" method="POST">
		<input type="hidden" name="command" value="login">
		<%
		System.out.println("Member : " + session);
		if(dto == null){
		%>
		<div>
			<span>userId : </span>
			<span><input type="text" name="userId"></span>
		</div>
		<div>
			<span>password : </span>
			<span><input type="password" name="password"></span>
		</div>
		<br>
		<div class="button" >
			<input type="submit" value="로그인하기" />
		</div>
		</form>
		<%
		} else if(dto != null){
		%>
		<div>
			<h2><%=dto.getUserName() %> 님, 안녕하세요! </h2>
			<input type="button" value="로그아웃하기" onclick="location.href='login.do?command=logout'" >
		</div>
		<%
		}
		%>
		
	</div>
</body>
</html>