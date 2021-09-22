<%@page import="com.muldel.dao.MDBoardDaoImpl"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
<%@page import="com.muldel.dto.MDBoardDto"%>
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
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MDBoardDto dto = new MDBoardDto();
	dto.setSeq(seq);
	dto.setTitle(title);
	dto.setContent(content);
	
	MDBoardDao dao = new MDBoardDaoImpl();
	int res = dao.update(dto);
	
	if(res > 0){
%>
	<script type="text/javascript">
		location.href="boardselect.jsp?seq=<%=dto.getSeq()%>"
	</script>
<%
	}else{
%>
	<script type="text/javascript">
		alert("글 수정 실패 코드 확인");
		location.href="boardupdate.jsp?seq=<%=dto.getSeq()%>"
	</script>
<%
	}
%>
<body>


</body>
</html>