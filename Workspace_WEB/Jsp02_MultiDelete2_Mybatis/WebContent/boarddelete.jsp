<%@page import="com.muldel.dao.MDBoardDaoImpl"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao = new MDBoardDaoImpl();
	
	int res = dao.delete(seq);
	
	if(res > 0){
%>
	<script type="text/javascript">
		location.href="boardlist.jsp"
	</script>
<%
	} else{
%>
	<script type="text/javascript">
		alert("글 삭제 실패 코드 확인");
		location.href="boardselect.jsp?seq=<%=seq%>"
	</script>
<%
	}
%>
</body>
</html>