<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
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
	String command = request.getParameter("command");
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	
	if(command.equals("login")){
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid, mypw);
		
		if (dto != null){
			
			// 로그인 할땐 주로 session에 담는다.
			// sesstion scope에 객체 담기
			session.setAttribute("dto", dto);
			// 만료되는 시간 설정 (default: 30분)
			session.setMaxInactiveInterval(10 * 60);
			
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			} else if (dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}
			
		} else {
			
%>
	<script type="text/javascript">
		alert("로그인 실패");
		location.href="index.html";
	</script>
<%
		}

		

	}else if(command.equals("logout")){ // session 에 값을 담아놨는데 로그아웃하면 
		// sesssion scope에서 값 삭제 (만료)
		session.invalidate();
		response.sendRedirect("index.html");
		
	}else if(command.equals("listall")){
		//1.
		
		//2.
		List<MYMemberDto> list = biz.selectAllUser();
		
		//3.
		request.setAttribute("list", list);
		
		//4.
		pageContext.forward("userlistall.jsp");
	}else if(command.equals("listen")){
		
		//1.
		
		//2.
		List<MYMemberDto> list = biz.selectEnabledUser();
		
		//3.
		request.setAttribute("list", list);
		
		//4.
		pageContext.forward("userlisten.jsp");
	} else if (command.equals("updateroleform")){
		//1.
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		//2. 
		MYMemberDto dto = biz.selectUser(myno);
		
		//3.
		request.setAttribute("dto", dto);
		
		//4.
		pageContext.forward("updaterole.jsp");
		
	} else if (command.equals("updaterole")){
		// 1.
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		// 2.
		int res = biz.updateRole(myno, myrole);
		// 3.
		
		// 4.
		if(res > 0) {
%>
	<script type="text/javascript">
		alert("등급 변경 성공");
		location.href="logincontroller.jsp?command=listen";
	</script>
<%
		}else{
%>
	<script type="text/javascript">
	 	alert("등급 변경 실패");
	 	location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
	</script>
<%
		}	
	}else if (command.equals("registform")){
		response.sendRedirect("regist.jsp");
		
	}else if (command.equals("idchk")){
		// 1.
		String myid = request.getParameter("myid");
		
		// 2.
		MYMemberDto dto = biz.idCheck(myid);
		boolean idnotused = true;
		
		if(dto.getMyid() != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
	}else if (command.equals("usersel")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("userselect.jsp");
	} else if (command.equals("usermain")){
		
		response.sendRedirect("usermain.jsp");
		
	} else if (command.equals("adminmain")){
		
		response.sendRedirect("adminmain.jsp");
	
	} else if (command.equals("userup")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		
		pageContext.forward("userupdate.jsp");
	
	} else if (command.equals("userupres")){
		
		
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		MYMemberDto dto = new MYMemberDto();
		dto.setMyno(myno);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		int res = biz.updateUser(dto);
		
		if(res > 0){
%>
	<script type="text/javascript">
		alert("수정 성공");
		location.href="logincontroller.jsp?command=usersel&myno=<%=myno%>";
	</script>
<%			
		} else {
%>
	<script type="text/javascript">
		alert("수정 실패");
		history.back();
	</script>
<%
		}
%>
<%
	} else if (command.equals("userdel")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		
		int res = biz.deleteUser(myno);
		
		if (res > 0){
%>
	<script type="text/javascript">
		alert("삭제 성공");
		location.href="logincontroller.jsp?command=index";
	</script>
<%			
		}else{
%>
	<script type="text/javascript">
		alert("삭제 실패");
		location.href="logincontroller.jsp?command=usersel&myno=<%=myno%>";
	</script>
<%	
		}
	}else if (command.equals("index")){
		response.sendRedirect("index.html");
		
	}else if (command.equals("insertuser")){
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		MYMemberDto dto = new MYMemberDto(0, myid, mypw, myname, myaddr, myphone, myemail, null, null);
		int res = biz.inserUser(dto);
		
		if(res > 0){
%>
	<script type="text/javascript">
		alert("가입 성공!");
		location.href="logincontroller.jsp?command=index";
	</script>	
<% 	
		}else{
%>
	<script type="text/javascript">
		alert("가입 실패!");
		history.back();
	</script>
<%
		}
	}
		
		
%>


















	<h1 style="color: red;">잘못왔다...</h1>

</body>
</html>