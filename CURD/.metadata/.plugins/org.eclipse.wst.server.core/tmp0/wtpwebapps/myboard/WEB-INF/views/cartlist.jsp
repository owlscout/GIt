<%@page import="com.mvc.myboard.userDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#mulorder").submit(function(){
		if($("#mulorder input:checked").length == 0){
			alert("체크하고 눌러주세요");
			return false;
		}
	});
});

function allCheck(bool){
	var chks = document.getElementsByName("chk");
	for (var i = 0; i < chks.length; i++){
		chks[i].checked = bool;
	}
}

$(function(){
	$(".chk").click(function(){
		var all = $("input:checkbox[name=chk]").length;
		var chk = $("input:checkbox[name=chk]:checked").length;
		console.log("all : " + all)
		console.log("chk : " + chk)
		if(all == chk){
			$("input:checkbox[name=all]").prop("checked", true);
		} else {
			$("input:checkbox[name=all]").prop("checked", false);
		}
		
	})
});

</script>
</head>
<%
	userDto login = (userDto) session.getAttribute("login");
%>
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

	<h1>장바구니</h1>
	<form action="mulorder.do" method="post" id="mulorder">
	<table border="1">
		<col width="50">
		<col width="100">
		<col width="100">
		<col width="100">
		<col width="120">
		<col width="50">
		<col width="50">
		<tr>
			<th><input type="checkbox" name="all" onclick="allCheck(this.checked);"></th>
			<th>상품사진</th>
			<th>상품명</th>
			<th>대분류</th>
			<th>소분류</th>
			<th>수량</th>
			<th>취소</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="7">--------장바구니에 담은 상품이 없습니다-----------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<th>
							<input type="checkbox" class="chk" name="chk" value="${dto.prono }">
							
						</th>
						<td>
							<img src="image/upload/${dto.proname }/${dto.protitle}" width="140" height="80">
						</td>
						<td>${dto.protitle }</td>
						<td>${dto.prokate_1 }</td>
						<td>${dto.prokate_2 }</td>
						<td>${dto.amount }</td>
						<td><input type="button" value="장바구니 삭제"
							onclick="location.href='cartdelete.do?cartno=${dto.cartno}&username=${login.username }'">
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="7" align="right">
				<input type="button" value="구매리스트" onclick="location.href='dellist.do'">
				<input type="button" value="상품보러가기" onclick="location.href='prolist.do'">
				<input type="submit" value="체크한 목록 주문하기">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>