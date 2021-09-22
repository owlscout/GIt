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
<%
	//		dto
	// view <--> dao <--> db
	String mywriter = request.getParameter("mywriter");
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	BoardDto dto = new BoardDto();
	dto.setMywriter(mywriter);
	dto.setMytitle(mytitle);
	dto.setMycontent(mycontent);
	
	BoardDao dao = new BoardDao();
	// 리턴 받는 결과 값은 int이기에 
	int res = dao.insert(dto);
	
	if (res > 0){
%>
	<script type="text/javascript">
	location.href="mylist.jsp";
	</script>
<%		
	} else {
%>
	<script type="text/javascript">
	alert("작성 실패! 오류, 오타를 찾으시오")
	location.href="myinsert.jsp";
	</script>
<% 
	}
%>
<body>

</body>
</html>