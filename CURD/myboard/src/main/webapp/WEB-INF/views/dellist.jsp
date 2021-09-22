<%@page import="com.mvc.myboard.userDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	userDto login = (userDto) session.getAttribute("login");
%>
</head>
<body>
	<table border="1" class="table_">
		<col width="100">
		<col width="350">
		<col width="100">
		<col width="150">
		<col width="200">
		<col width="120">
		<col width="50">
		<tr class="table_head">
			<th>주문번호</th>
			<th>구매내역</th>
			<th>총 금액</th>
			<th>배송상태</th>
			<th>배송지</th>
			<th>구매일</th>
			<th>취소</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4">--------구매하신 상품이 없습니다.-----------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
						<tr class="table_content">
							<td>${dto.delno }</td>
							<c:if test="${dto.proamout eq 0 }">
							<td><a href="ordlist.do?delno=${dto.delno }">${dto.protitle } 상품을 주문하셨습니다.</a></td>	
							</c:if>
							<c:if test="${dto.proamout > 0 }">
							<td><a href="ordlist.do?delno=${dto.delno }">${dto.protitle } 외 ${dto.proamout }개의 상품을 주문하셨습니다.</a></td>
							</c:if>
							<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.total }" /></td>
							<td>${dto.delstate }</td>
							<td>${dto.address_1 } ${dto.address_2 }</td>
							<td>${dto.deldate }</td>
    						<td>
    							<input type="button" value="구매 취소" onclick="location.href='delcancel.do?delno=${dto.delno}'">
							</td>
						</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="6" align="right">
				"${login.username }" 님의 주문 건수는 ${count }개 / 총 금액은 <fmt:formatNumber type="number" maxFractionDigits="3" value="${total }" /> 원 입니다.
				
			</td>
		</tr>
		<tr>
			<td colspan="6" align="right">
				<c:if test="${not empty login }">
					<input type="button" value="장바구니 가기" onclick="location.href='clist.do?username=${login.username}'">
				</c:if>
				<input type="submit" value="체크한 목록 장바구니에 담기">
			</td>
		</tr>
	</table>
	
	
	
</body>
</html>