<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="updateres.do" method="post">
		<input type="hidden" name="prono" value="${dto.prono }">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${dto.proname }</td>
			</tr>
			<tr>
				<th>제목</th>				
				<td><input type="text" name="protitle" maxlength="30" value='${dto.protitle }' placeholder="50자까지 작성 가능합니다"></td>
			</tr>	
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="60" id="procontent" name="procontent" placeholder="1000byte까지 작성 가능합니다">${dto.procontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right" id="textlength">0/1000byte
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="글수정">
					<input type="button" value="취소" onclick="history.go(-1); return false;">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>