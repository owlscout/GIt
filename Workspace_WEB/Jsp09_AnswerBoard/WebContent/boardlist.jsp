<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Answer List</h1>
	
	<table border="1">
		<col width ="50px" />
		<col width ="500px" />
		<col width ="120px" />
		<col width ="100px" />
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4">---------작성된 글이 없습니다 -------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.boardno }</td>
						<td>
							<c:forEach begin="1" end="${dto.titletab }"> <!-- 1~0까지 1~1까지면 1번 반복 1~2까지면 2번 반복 -->
								&nbsp; <!-- 공백, 탭 -->
							</c:forEach>
							<a href="answer.do?command=detail&boardno=${dto.boardno }">${dto.title }</a>
						</td>
						<td>${dto.writer }</td>
						<td>${dto.regdate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글장석" onclick="answer.do?command=insert">
			</td>
		</tr>
	</table>
	
</body>
</html>