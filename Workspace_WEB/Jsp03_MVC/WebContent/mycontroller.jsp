<%@page import="com.mvc.dao.MVCBoardDao"%>
<%@page import="com.mvc.dao.MVCBoardDoaImpl"%>
<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
	System.out.printf("[%s]\n", command);
	
	MVCBoardBiz biz = new MVCBoardBizImpl(); 
	// forward 는 고객센터에서 다른부서로 연결해드리겠습니다 같은 느낌
	// sendRedirect 는 다른 번호를 주면서 여기로 다시 전화해주세요 라는느낌
	// 요청한 명령을 확인한다.
	if(command.equals("list")){
		// 1. 보내준 값이 있으면, 받는다.
		
		// 2. db에 전달할 값이 있으면 전달하고 
		//    없으면 없는대로 호출해서 리턴받는다.
		List<MVCBoardDto> list = biz.selectList();
		
		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		request.setAttribute("list", list); // request에다가 list 객체를 "list"로 담았다.
		
		// 4. 보낸다. // 
		pageContext.forward("mylist.jsp");
		
	} else if (command.equals("insertform")){
		// 1.
		// 2.
		// 3.
		// 4.
		response.sendRedirect("myinsert.jsp"); // 값을 보내는게아닌 그냥 insert.jsp 로 보내서 하는것이다.
		/*
			pageContext.forward() : 페이지 위임 (request, response 객체가 그대로 전달)
			response.sendRedirect() : 페이지 이동 (새로운 request, response 객체)
		*/
	} else if (command.equals("insertres")){
		// 1. 
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2.
		MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
		int res = biz.insert(dto);
		
		// 3.
		
		// 4.
		if (res > 0){
%>
		<script type="text/javascript">
			alert("글 작성 성공");
			location.href='mycontroller.jsp?command=list';
		</script>
<%			
		} else{
%>
		<script type="text/javascript">
		 alert("글 작성 실패");
		 location.href='mycontroller.jsp?command=insertform';
		</script>
<%			
		}
	} else if(command.equals("selectone")) {
		// 1. 보내준 값 있으면 값 받기
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2.
		MVCBoardDto dto = biz.selectOne(seq);
		// 3.
		request.setAttribute("dto", dto);
		// 4.
		pageContext.forward("myselect.jsp");
		
	} else if(command.equals("updateform")){
		// 1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2.
		MVCBoardDto dto = biz.selectOne(seq);
		// 3.
		request.setAttribute("dto", dto);
		// 4.
		pageContext.forward("myupdate.jsp");
		
	} else if(command.equals("updateres")){
		// 1.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2.
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		int res = biz.update(dto);
		// 3.
		
		// 4.
		if(res > 0){
%>
	<script type="text/javascript">
		alert("수정 성공!");
		location.href="mycontroller.jsp?command=selectone&seq=<%=seq%>";
	</script>
<%
		} else{
%>
	<script type="text/javascript">
		alser("수정 실패!");
		history.back();
	</script>
<%	
		}
	} else if(command.equals("deleteform")){
		// 1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2.
		int res = biz.delete(seq);
		// 3.
		
		// 4.
		if(res > 0){
%>
	<script type="text/javascript">
		alert("삭제 성공!");
		location.href="mycontroller.jsp?command=list";
	</script>
<% 			
		} else{
%>
	<script type="text/javascript">
		alert("삭제 실패!");
		location.href="mycontroller.jsp?command=selectone&seq=<%=seq%>";
	</script>
<%			
		}
	}
%>

</body>
</html>