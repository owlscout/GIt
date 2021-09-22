<%@page import="com.board.dao.BoardDao"%>
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
	int myseq = Integer.parseInt(request.getParameter("myseq"));
	BoardDao dao = new BoardDao();
	int res = dao.delete(myseq);
	
	if (res >0){
%>
<script type="text/javascript">
	location.href="mylist.jsp";
</script>
<% 		
	} else {
%>
<script type="text/javascript">
	alert("삭제 실패 코드를 확인해 주세요");
	location.href="myselect.jsp?myseq=<%=myseq%>";
</script>
<%		
	}
	
%>
</body>
</html>