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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<body>
	
	<table border="1">
		<tr>
			<td>
				<img src="image/upload/${dto.proname }/${dto.protitle}" width="340" height="300">
			</td>
			<td>
				<table border="1" style="height: 300px; width: 400px;">
					<tr>
						<th>상품명</th>
						<td>${dto.protitle }</td>
					</tr>
					<tr>
						<th>상품소개</th>
						<td>
							${dto.procontent }
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<%
							if(login != null){
						%>
							<form action="cartinsert.do" method="post">
								<input type="hidden" name="prono" value="${dto.prono }">
								<input type="hidden" name="protitle" value="${dto.protitle }">
								<input type="hidden" name="proname" value="${dto.proname }">
								<input type="hidden" name="username" value="${login.username }">
								<input type="hidden" name="prokate_1" value="${dto.prokate_1 }">
								<input type="hidden" name="prokate_2" value="${dto.prokate_2 }">
								<input type="number" name="amount" maxlength="2" value="1">
								&nbsp;개 &nbsp;&nbsp;
								<input type="submit" value="장바구니 담기">
							</form>
						<%
							} else {
						%>
							<form action="nonmembercartinsert.do" method="post">
								<input type="hidden" name="prono" value="${dto.prono }">
								<input type="hidden" name="protitle" value="${dto.protitle }">
								<input type="hidden" name="proname" value="${dto.proname }">
								<input type="hidden" name="username" value="${login.username }">
								<input type="hidden" name="prokate_1" value="${dto.prokate_1 }">
								<input type="hidden" name="prokate_2" value="${dto.prokate_2 }">
								<input type="number" name="amount" maxlength="2" value="1">
								&nbsp;개 &nbsp;&nbsp;
								<input type="submit" value="비회원 장바구니 담기">
							</form>
						<%
							}
						%>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
							
				<input type="button" value="수정" id="updateBtn2" onclick="location.href='proupdate.do?prono=${dto.prono }'">
				<input type="button" value="삭제" id="deleteBtn2" onclick="location.href='prodelete.do?prono=${dto.prono }'">
			
				<input type="button" value="목록" onclick="location.href='prolist.do'">
			</td>
		</tr>
	</table>
	
</body>
<script type="text/javascript">
	$(".amount").keyup(function(event){
	    var inputVal = $(this).val();
	    $(this).val(inputVal.replace(/[^0-9]/gi,''));
	});
</script>
</html>