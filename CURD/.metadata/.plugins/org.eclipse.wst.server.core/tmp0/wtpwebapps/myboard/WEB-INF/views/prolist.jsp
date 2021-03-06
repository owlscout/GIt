<%@page import="com.mvc.myboard.userDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#mulinsert").submit(function(){
		if($("#mulinsert input:checked").length == 0){
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

function katechange(kate){
	var target = $("select[name='kate_2']");
	
	if(kate == "" || kate == null){
		target.children().remove();
		target.append("<option value=''>값이 없습니다.</option>");
		return;
	}
	
	$("#kategori").val(kate);

	$.ajax({
		type : "post",
		url: "kate.do?prokate_1=",
		data: kate,
		contentType: "application/json; charset=UTF-8",
		dataType: "json",
		success:function(json){
			
			target.children().remove();
			if(json.length == 0){
				
				target.append("<option value=''>값이 없습니다.</option>");
			}else{
				target.append("<option value='전체'>전체</option>");
				for (var i = 0; i < json.length; i++){
						
						target.append("<option value=" + json[i] + ">" + json[i] + "</option>");
				}
			}
		}, error: function(){
			alert("통신실패");
		}
		
	});
	
}

 function katelist(kate2){
	var target = $(".table_");
	var foot = $(".table_foot")
	var head = $(".table_head")
	var kate = $("#kategori").val();
	
	var kateVal = {
					"prokate_1" : kate,
					"prokate_2" : kate2
	}
	
	$.ajax({
		type : "post",
		url: "kate2.do",
		data: JSON.stringify(kateVal),
		contentType: "application/json; charset=UTF-8",
		dataType: "json",
		success:function(json){
			console.log('판매자')
			console.log(json[0].prono)
			console.log(json.length)
			target.find(".table_content").remove();
			if(json.length == 0){
				target.append("<tr><th colspan='4'>--------해당하는 카테고리와 맞는 상품이 없습니다.-----------</th></tr>");
			}else{
				for (var i = 0; i < json.length; i++){	
						var content = $("<tr>")
						
						content.addClass("table_content")
						content.append("<th><input type='checkbox' class='chk' name='chk' value="+ json[i].prono +"></th>");
						content.append("<td class='kate1'>"+ json[i].prokate_1 +"</td>");
						content.append("<td class='kate2'>"+ json[i].prokate_2 +"</td>");
						content.append("<td><img src='image/upload/" + json[i].proname + "/" + json[i].protitle + "' width='140' height='100'></td>");
						content.append("<td><a href='proselect.do?prono=" + json[i].prono +"'>" + json[i].protitle + "</a></td>");
						content.append("<td>"+ json[i].prodate + "</td>");
						foot.before(content);
				}
			}
		}, error: function(){
			alert("통신실패");
		}
	});
	
} 

</script>
<%
	userDto login = (userDto) session.getAttribute("login");
%>

</head>
<body>
<%
	if(login == null){
%>
	<h2>환영합니다</h2> <input type="button" value="로그인" onclick="location.href='login.do'"><input type="button" value="회원가입" onclick="location.href='signup.do'">
<%
	} else if (login != null){
%>
	<h2>"${login.username }"님 환영합니다.</h2> <input type="button" value="로그아웃" onclick="location.href='logout.do'"> <br>
	<input type="button" value="장바구니" onclick="location.href='cartlist.do?username=${login.username}'"><br>
<%
	}
%>
	
	<h1>상품 리스트</h1>
	<input type="button" value="비회원 장바구니 가기" onclick="location.href='cartlist.do'"><br>
	<select name="kate_1" onchange="katechange(this.value);">
		<option value="">선택</option>
		<option value="음식">음식</option>
		<option value="의류">의류</option>
		<option value="가전">가전</option>
	</select>
	<input type="hidden" value="" id="kategori">
	<select name="kate_2" onchange="katelist(this.value);">
	
	</select>
	<form action="mulinsert.do" method="post" id="mulinsert">
	<input type="hidden" name="username" value="${login.username }">
	<table border="1" class="table_">
		<col width="50">
		<col width="100">
		<col width="120">
		<col width="100">
		<col width="500">
		<col width="150">
		<tr class="table_head">
			<th><input type="checkbox" name="all" onclick="allCheck(this.checked);"></th>
			<th>대분류</th>
			<th>소분류</th>
			<th>썸네일</th>
			<th>상품명</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4">--------작성된 글이 없습니다-----------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<c:if test="${dto.proshow eq 1 }">
						<tr class="table_content">
							<th>
								<input type="checkbox" class="chk" name="chk" value="${dto.prono }">
							</th>
							<td class="kate1">${dto.prokate_1 }</td>
							<td class="kate2">${dto.prokate_2 }</td>
							<td>
								<img src="image/upload/${dto.proname }/${dto.protitle}" width="140" height="100">
							</td>
							<td><a href="proselect.do?prono=${dto.prono }">${dto.protitle }</a></td>
							<td>
								<!--<fmt:formatDate value="${dto.prodate }" type = "date"/>-->
								${dto.prodate }
    						</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr class="table_foot">
			<td colspan="6" align="right">
				<c:if test="${not empty login }">
					<input type="button" value="장바구니 가기" onclick="location.href='clist.do?username=${login.username}'">
				</c:if>
				<input type="button" value="관리자페이지" onclick="location.href='admin.do'">
				<input type="button" value="상품 등록" onclick="location.href='proinsert.do'">
				<%
					if (login != null){
				%>
				<input type="submit" value="체크한 목록 장바구니에 담기">
				<%
					}
				%>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>