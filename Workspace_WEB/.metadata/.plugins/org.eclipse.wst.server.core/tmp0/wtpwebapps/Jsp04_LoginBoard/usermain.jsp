<%@page import="com.login.dto.MYMemberDto"%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Expires", "0");
%>
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
	MYMemberDto dto = (MYMemberDto)session.getAttribute("dto");
%>
<body>
	<div>
		<h2><%=dto.getMyid() %>님 환영합니다.</h2>
		<a href="logincontroller.jsp?command=usersel&myno=<%=dto.getMyno()%>">정보 조회</a>
	</div>
	<div>
		<div>
			<a href="logincontroller.jsp?command=userup&myno=<%=dto.getMyno()%>">정보 수정</a>
		</div>
		<div>
			<a href="logincontroller.jsp?command=userdel&myno=<%=dto.getMyno()%>">회원 탈퇴</a>
		</div>
	</div>
</body>
</html>