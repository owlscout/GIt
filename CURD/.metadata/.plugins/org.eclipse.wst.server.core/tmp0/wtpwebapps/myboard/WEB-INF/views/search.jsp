<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
					<th colspan="4">--------검색된 글이 없습니다-----------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.myno }</td>
						<td>${dto.myname }</td>
						<td><a href="select.do?myno=${dto.myno }">${dto.mytitle }</a></td>
						<td>${dto.mydate }</td>
						<td>${dto.readcount }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="5" align="right">
				<input type="button" value="검색 결과 엑셀로 받기" onclick="location.href='listexcel.do?searchOption=${sdto.searchOption }&searchText=${sdto.searchText }'">
				<input type="button" value="검색 결과 텍스트로 받기" onclick="location.href='listtxt.do?searchOption=${sdto.searchOption }&searchText=${sdto.searchText }'">
				<input type="button" value="글작성" onclick="location.href='insert.do'">
				<input type="button" value="목록" onclick="listPage.do?nowPage=1&cntPerPage=10">
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
	
	
	
</body>
</html>