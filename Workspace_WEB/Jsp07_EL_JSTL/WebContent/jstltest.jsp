<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>JSTL : Jsp Standard Tag Library</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>		<!-- for(Score score : list) -->
		<c:forEach items="${list }" var="score"> <!-- 반복문 , items = Collection객체(list, ArrayList) var : 사용할 변수 (var, items는 필수로 써야한다.) -->
			<tr>
				<td>	<!-- eq: == / ne : != / empty: null -->
					<c:if test="${score.name eq '이름10' }"><!--if문으로 else구문은 없다. test : 필수 속성으로 속성값으로 el비교식을 가집니다. -->
						<c:out value="홍길동"></c:out>	<!-- c:out = 출력 같은<td>에 속해있어서 홍길동이 출력되고 choose문의 otherwise에 홍길동이없으므로 누구지? 가 추가된것이다. -->
					</c:if>
					<!-- 조건에 따른 분기 -->
					<c:choose>
						<c:when test="${score.name eq '이름20' }">	
							<c:out value="${score.name }님!"></c:out>	
						</c:when>
						<c:when test="${score.name eq '이름30' }">
							<c:out value="${score.name }"></c:out> 
						</c:when>
						<c:otherwise>	
							<c:out value="누구지?"></c:out>
						</c:otherwise>
					</c:choose>
					<!-- otherwise는 default, else와 같은 역할이다 위에 조건들이 아닌 다른것들일 경우 -->
				</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.sum }</td>
				<td>${score.avg }</td>
				<td>
					<c:choose><!-- 등급이 a,b이면 통과 아니면 fail -->
						<c:when test="${score.grade eq 'A' || score.grade eq 'B' }">
							<c:out value="PASS"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="FAIL"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	

	
	
</body>
</html>