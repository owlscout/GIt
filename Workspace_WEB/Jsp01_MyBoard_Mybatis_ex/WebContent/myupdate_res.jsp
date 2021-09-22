<%@page import="com.board.dao.BoardDao"%>
<%@page import="com.board.dto.BoardDto"%>
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
<%
	int myseq = Integer.parseInt(request.getParameter("myseq"));
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	//BoardDao dao = new BoardDao(myseq, null, mytitle, mycontent, null);
	BoardDto dto = new BoardDto();
	dto.setMyseq(myseq);
	dto.setMytitle(mytitle);
	dto.setMycontent(mycontent);
	
	BoardDao dao = new BoardDao();
	int res = dao.update(dto);
	
	if(res > 0){
%>
<script type="text/javascript">
	location.href="myselect.jsp?myseq=<%=myseq%>";
</script>
	
<% 		
		
		
	} else{
%>
<script type="text/javascript">
	alert("수정 실패 코드를 확인해주세요.")
	location.href="myupdate.jsp?myseq=<%=myseq%>"
</script>

<%		
	}
	
%>

</body>
</html>