<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function cancel(){
		var selected = $("#cancelreason option:selected").val();
		console.log(selected);
		
		$("#reason").val(selected);
		
	}
</script>
</head>
<body>
	
	<form action="delcancelres.do" method="post">
	<input type="hidden" name="delno" value="${delno }">
	<table border="1">
		<tr>
			<th>취소사유</th>
			<td>
				<select id="cancelreason" onchange="cancel();">
					<option value="">직접 입력</option>
					<option value="단순 변심">단순 변심</option>
					<option value="색상, 사이즈 다시 고르기">색상, 사이즈 다시 고르기</option>
					<option value="재고 부족">재고 부족</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>직접입력</th>
			<td>
				<textarea rows="10" cols="60" name="reason" id="reason"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="취소신청">
				<input type="button" value="구매 목록" onclick="location.href='dellist.do'">
			</td>
		</tr>
	</table>
	</form>
	
</body>
</html>