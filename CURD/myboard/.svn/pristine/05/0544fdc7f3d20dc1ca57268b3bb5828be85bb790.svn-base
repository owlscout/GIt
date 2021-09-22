<%@page import="com.mvc.myboard.userDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%
	userDto login = (userDto) session.getAttribute("login");
%>
</head>
<body>
	
	
<%
	if(login == null){
%>
	<h2>환영합니다</h2> <input type="button" value="로그인" onclick="location.href='login.do'"><input type="button" value="회원가입" onclick="location.href='signup.do'">
<%
	} else if (login != null){
%>
	<h2>"${login.username }"님 환영합니다.</h2> <input type="button" value="로그아웃" onclick="location.href='logout.do'"> 
<%
	}
%>
	<table border="1">
		<col width="50">
		<col width="100">
		<col width="500">
		<col width="100">
		<col width="50">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4">--------작성된 글이 없습니다-----------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.myno }</td>
						<td>${dto.myname }</td>
						<td><a href="select.do?myno=${dto.myno }&nowPage=${paging.nowPage}">${dto.mytitle }</a></td>
						<td>${dto.mydate }</td>
						<td>${dto.readcount }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="5" align="right">
				<input type="button" value="글작성" onclick="location.href='insert.do?nowPage=${paging.nowPage}'">
			</td>
		</tr>
	</table>
	<form action="search.do" method="post">
		<table align="center">
			<tr>
				<td >
					<select name="searchOption">
						<option value="mytitle">제목</option>
						<option value="mycontent">내용</option>
						<option value="myname">글쓴이</option>
					</select>
					<input type="hidden" name="nowPage" value="1">
					<input type="hidden" name="cntPerPage" value="10">
					<input type="text" name="searchText">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	<div align="center">
		<c:if test="${paging.startPage != 1 }">
			<a href="listPage.do?nowPage=1&cntPerPage=${paging.cntPerPage}">&lt;&lt;</a>
		</c:if>
		<c:if test="${paging.startPage != 1 }">
			<a href="listPage.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="listPage.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="listPage.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="listPage.do?nowPage=${paging.lastPage }&cntPerPage=${paging.cntPerPage}">&gt;&gt;</a>
		</c:if>
	</div>

</body>
</html>