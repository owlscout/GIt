<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<% 			
			String writer =request.getParameter("writer");
			String title = request.getParameter("title");
			String content =request.getParameter("content");
			
			MDBoardDto dto= new MDBoardDto();
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			MDBoardBiz biz = new MDBoardBizImpl();
			
			int res = biz.insert(dto);
			
			if(res>0){

%>
			<script type="text/javascript">
			alert("성공!!!축하해!!");
			location.href ="boardlist.jsp";
			
			</script>

<%
			}else{
%>
			<script type="text/javascript">
			alert("실패......아.....아...");
			location.href ="boardlist.jsp";
			
			</script>



<%
			}
%>
</head>
<body>

</body>
</html>