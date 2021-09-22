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
	<!-- 서블릿으로 request받는거다 dto라는 값을 받아서 forward할것이다. com.mvc.dto.MVCBoardDto 여기에 dto가 있으면 거기에 담아두고 없으면 새로만든다. -->
	<jsp:useBean id="dto" class="com.mvc.dto.MVCBoardDto" scope="request"></jsp:useBean>
	
	<h1>UPDATE</h1>
	
	<form action="mvc.do" method="post">
		<input type="hidden" name="command" value="updateres"/>
		<input type="hidden" name="seq" value='<jsp:getProperty property="seq" name="dto"/>'/><!-- dto.getSeq() -->
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><jsp:getProperty property="writer" name="dto"/></td>
			</tr>
			<tr>
				<th>제목</th>				<!-- dto.getTitle(); -->
				<td><input type="text" name="title" value='<jsp:getProperty property="title" name="dto"/>'></td>
			</tr>	
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="60" name="content"><jsp:getProperty property="content" name="dto"/></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="mvc.do?command=select&seq=${dto.seq}">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>