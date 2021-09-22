<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<style type="text/css">

.colsp.on {
	display: none;
}


</style>
<body>

	<h1>상품 리스트</h1>
	<input type="button" value="장바구니" onclick="location.href='cartlist.do?username=${login.username}'">
	<form action="mulupdate.do" method="post" id="mulinsert">
	<input type="hidden" name="username" value="${login.username }">
	<table border="1">
		<col width="100">
		<col width="100">
		<col width="100">
		<col width="120">
		<col width="100">
		<col width="300">
		<col width="120">
		<col width="100">
		<tr>
			<th>상품번호</th>
			<th>대분류</th>
			<th>소분류</th>
			<th>썸네일</th>
			<th>상품명</th>
			<th>작성일</th>
			<th>상품노출</th>
			<th>버튼</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="8">--------작성된 글이 없습니다-----------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto" varStatus="status">

						<tr class="colsp">
							<td>${dto.prono }
								<input type="hidden" name="prono" value="${dto.prono }">
							</td>
							<td class="kate1"><input type="text" name="prokate_1" value="${dto.prokate_1 }"></td>
							<td class="kate2"><input type="text" name="prokate_2" value="${dto.prokate_2 }"></td>
							<td>
								<img src="image/upload/${dto.proname }/${dto.protitle}" width="140" height="100">
							</td>
							<td><input type="text" name="protitle" value="${dto.protitle }"></td>
							<td>${dto.prodate }</td>
							<td>
								<c:if test="${dto.proshow eq 1 }">
									<select class="proshow">
										<option value="1" selected="selected">보인다</option>
										<option value="0">안보인다</option>
									</select>
								</c:if>
								<c:if test="${dto.proshow eq 0 }">
									<select class="proshow">
										<option value="1">보인다</option>
										<option value="0" selected="selected">안보인다</option>
									</select>
								</c:if>
								<input type="hidden" class="proshowchk" name="proshow" value="${dto.proshow }">
							</td>
							<td class="del">
								<input type="button" value="삭제" onclick="muldelete(${status.index})">
								<input type="hidden" name="status" value="수정">
							</td>
						</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="8" align="right">
				<input type="button" value="상품보러가기" onclick="location.href='prolist.do'">
				<input type="button" value="상품 등록" onclick="location.href='proinsert.do'">
				<input type="button" value="주문 내역" onclick="location.href='ordhis.do'">
				<input type="submit" value="디비에 저장">
			</td>
		</tr>
	</table>
	</form>

<script type="text/javascript">
	

	$(function(){
		$(".proshow").change(function(){
			var selected = $(this).val();
			$(this).parent().find("input[name=proshow]").val(selected);
		})
	});
	
	
	
	function muldelete(index){
		console.log(index);
		$(".colsp").eq(index).addClass("on");
		var chk = $(".status").eq(index);
		console.log(chk)
		var chk2 = $(".del").eq(index).find("input[name=status]").val();
		console.log(chk2)
		$(".del").eq(index).find("input[name=status]").val("삭제");
		console.log($(".del").eq(index).find("input[name=status]").val())
	}
	
</script>

</body>
</html>