<%@page import="com.mvc.myboard.userDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	userDto login = (userDto) session.getAttribute("login");
%>
<body>
	
	<form action="proinsertres.do" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>판매자</th>
				<td><input type="text" name="proname"></td>
			</tr>
			<tr>
				<th>분류</th>
				<td>
					<input type="text" name="prokate_1" placeholder="대분류">&nbsp;/&nbsp;
					<input type="text" name="prokate_2" placeholder="소분류">
				</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="protitle" maxlength="30" id="protitle" placeholder="50자까지 작성 가능합니다"></td>
			</tr>
			<tr>
				<th>상품소개</th>
				<td>
					<textarea rows="10" cols="60" name="procontent" id="procontent"  placeholder="1000byte까지 작성 가능합니다"></textarea>
				</td>
			</tr>
			<tr>
				<th>파일 업로드</th>
				<td>
					<input type="file" name="fileup"> 3MB의 용량까지만 업로드 가능합니다
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="글작성">
					<input type="button" value="취소" onclick="history.back();" />
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>