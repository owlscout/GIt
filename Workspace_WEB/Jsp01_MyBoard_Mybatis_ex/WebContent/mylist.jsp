<%@page import="com.board.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.board.dao.BoardDao"%>
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
	BoardDao dao = new BoardDao();
	// 전체화면 출력
	// list<BoardDto> list에 dao.selectList를 담는다.
	List<BoardDto> list = dao.selectList();
%>

<body>

	<h1> 자유 게시판 </h1>
	<table border="1">
		<col width="50px" />
		<col width="100px" />
		<col width="300px" />
		<col width="100px" />
		<tr>
			<th>번호</th>
			<th>글쓴이</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
<%
	for(int i = 0; i <list.size(); i++){
	// for(BoardDto dto : list){
	
%>
		<tr>
			<td><%=list.get(i).getMyseq() %></td>
			<td><%=list.get(i).getMywriter() %></td>
						<!-- ?myseq=<.%list.get(i).getMyseq() %>로 해당 row를 가져와서 볼것이다. -->
			<td><a href="./myselect.jsp?myseq=<%=list.get(i).getMyseq() %>"><%=list.get(i).getMytitle() %></a></td>
			
			<td><%=list.get(i).getMydate() %></td>
		</tr>
<%
	}
%>	
		<tr>
			<td colspan="4" align="right">
				<button onclick="location.href='./myinsert.jsp'">글쓰기</button>
			</td>
		</tr>
	</table>
	
</body>
</html>