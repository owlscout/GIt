<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" class="table_">
		<col width="100">
		<col width="200">
		<col width="100">
		<col width="100">
		<col width="50">
		<col width="300">
		<col width="120">
		<tr class="table_head">
			<th>주문번호</th>
			<th>썸네일</th>
			<th>상품명</th>
			<th>판매자</th>
			<th>수량</th>
			<th>금액</th>
			<th>주문날짜</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="7">--------주문한 물품이 없습니다.-----------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
						<tr class="table_content">
							<td>${dto.ordno }</td>
							<td><img src="image/upload/${dto.proname }/${dto.protitle}" width="140" height="100"></td>
							<td>${dto.protitle }</td>
							<td>${dto.proname }</td>
							<td>${dto.amout }</td>
							<c:if test="${dto.tax eq 20 }">
							<td>
								<table border="1">
									<col width="100">
									<col width="100">
									<col width="100">
									<tr>
										<th>원금</th>
										<th>부가세</th>
										<th>결제금액</th>
									</tr>
									<tr>
										<td>${dto.principal * dto.amout }</td>
										<td>${100 * dto.amout }</td>
										<td>${dto.ordprice * dto.amout }</td>
									</tr>
								</table>
							</td>
							</c:if>
							<c:if test="${dto.tax eq 10 }">
							<td>
								${dto.ordprice * dto.amout }
							</td>
							</c:if>
							<td>
								${dto.orddate }
    						</td>
						</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr class="table_foot">
			<td colspan="7" align="right">
				<c:if test="${not empty login }">
					<input type="button" value="장바구니 가기" onclick="location.href='clist.do?username=${login.username}'">
				</c:if>
				<input type="button" value="관리자페이지" onclick="location.href='admin.do'">
				<input type="button" value="상품 등록" onclick="location.href='proinsert.do'">
				<input type="submit" value="체크한 목록 장바구니에 담기">
			</td>
		</tr>
	</table>
</body>
</html>