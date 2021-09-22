<%@page import="com.login.dto.MYMemberDto"%>
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
	MYMemberDto dto =(MYMemberDto) request.getAttribute("dto");
%>
<body>
	<h1>정보 보기</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><%=dto.getMyid() %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=dto.getMypw() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=dto.getMyaddr() %></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=dto.getMyphone() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getMyemail() %></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="목록" onclick="location.href='logincontroller.jsp?command=usermain'">
				<input type="button" value="회원 정보 수정" onclick="location.href='logincontroller.jsp?command=userup&myno=<%=dto.getMyno()%>'">
			</td>
		</tr>
	</table>
</body>
</html>