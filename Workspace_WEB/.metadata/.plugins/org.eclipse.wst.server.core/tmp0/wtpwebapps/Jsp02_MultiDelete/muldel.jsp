
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String[] seqs = request.getParameterValues("chk");

	if(seqs == null || seqs.length == 0){
		
%>
<script type="text/javascript">
	alert("삭제하려는 글을 체크하세요");
	location.href="boardlist.jsp";
</script>
<%
	} else{
		MDBoardBiz biz = new MDBoardBizImpl();
		int res = biz.multiDelete(seqs);
		if(res > 0){
%>
<script type="text/javascript">
	alert("삭제 성공");
	location.href="boardlist.jsp";
</script>
<%
		}else{
%>
<script type="text/javascript">
	alert("삭제 실패 코드확인");
	location.href="boardlist.jsp";
</script>
<%
		}
	}
%>
<body>


</body>
</html>