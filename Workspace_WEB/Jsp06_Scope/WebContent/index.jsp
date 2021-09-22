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
	pageContext.setAttribute("pageId", "my pageContext value");
	request.setAttribute("requestId", "my request value");
	session.setAttribute("sessionId", "my session value");
	application.setAttribute("applicationId", "my application value");
%>
<body>
	
	<h1>INDEX</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %><br>
	requestId : <%=request.getAttribute("requestId") %><br>
	sessionId : <%=session.getAttribute("sessionId") %><br>
	applicationId : <%=application.getAttribute("applicationId") %><br>
	
	<a href="result.jsp">result</a><br>
	<!-- scope.do에게 요청하면서 값을 전달하겠다. -->
	<form action="scope.do" method="post">
		<input type="hidden" name="myRequest" value="my request value 2" />
		<input type="submit" value="controller" />
	</form>
	<!-- setAttribute : request에 담기
		getAttribute : 담아둔거 가져오기
		*.do?k=v
		<form action="*.do">
			<input type='' name='k' value='v'>
		getParameter : 전달된거 받아오기 -->
		<!-- forward로 해서 index의 값을 넣은 request를 아에 
		servlet에 위임해버려서 request의 값이 null이아닌 제대로 된 값이 나온다.  -->
	
	
</body>
</html>