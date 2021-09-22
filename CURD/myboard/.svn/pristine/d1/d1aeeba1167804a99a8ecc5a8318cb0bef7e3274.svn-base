<%@page import="com.mvc.myboard.myboardDto"%>
<%@page import="com.mvc.myboard.userDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {display:inline-block;}

.answertext {
	margin-left: 20px;
	display: none;
}

.answertext.on {
	display: block;
}

.updatetext {
	display: none;
}

.updatetext.on {
	display: block;
}

.comment {
	display: block;
}

.comment.on {
	display: none;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%
	userDto login = (userDto) session.getAttribute("login");
	myboardDto dto = (myboardDto) request.getAttribute("dto");
%>
</head>
<body>
	<input type="hidden" id="myno" value="${dto.myno }">
	<table border="1">
		<tr>
			<th>글쓴이</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" readonly="readonly">${dto.mycontent }</textarea></td>
		</tr>
		<%
			if(login == null){
		%>
		<tr>
			<th>게시글 비밀번호</th>
			<td>
				<input type="password" id="pw" maxlength="4" placeholder="수정과 삭제를 원하면 비밀번호를 입력하세요">
			</td>
		</tr>
		<%
			}
		%>
		<tr>
			<th>파일 다운로드</th>
		<%
			if(dto.getFileupdown() == "BLANK"){		
		%>
			<td>
					<input type="text" value="---파일이 없습니다 ---">
			</td>
			
		<%
			} else {
		%>
			<td>
				<form action="download.do" method="post">
					<input type="hidden" name="myname" value="${dto.myname }">
					<input type="hidden" name="filedown" value="${dto.fileupdown}">
					${dto.fileupdown}
					<input type="submit" value="다운로드">
				</form>
			</td>
		<%
			}
		%>
		</tr>
		<tr>
			<td colspan="2" align="center" id="pwRes">
			</td>
		</tr>
		<tr>
			<th>게시글 내용 다운받기</th>
			<td>
				<form action="exceldown.do" method="post">
					<input type="hidden" name="myno" value="${dto.myno }">
					<input type="submit" value="엑셀로 받기">
				</form>
				<form action="txtdown.do" method="post">
					<input type="hidden" name="myno" value="${dto.myno }">
					<input type="submit" value="텍스트로 받기">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<c:if test="${login == null}">
				<input type="button" value="수정" id="updateBtn1" onclick="pwChk();">
				<input type="button" value="삭제" id="deleteBtn1" onclick="pwChk2();">
			</c:if>
			<c:if test="${login.username eq dto.myname }">
				<input type="button" value="수정" id="updateBtn2" onclick="location.href='update.do?myno=${dto.myno }'">
				<input type="button" value="삭제" id="deleteBtn2" onclick="location.href='delete.do?myno=${dto.myno }'">
			</c:if>
				<input type="button" value="목록" onclick="location.href='listPage.do?nowPage=${nowPage}&cntPerPage=10'">
			</td>
		</tr>
	</table>
	
<%@ include file="./comment.jsp" %>
	
	
	<script type="text/javascript">
	// 비회원일때 비밀번호로 수정 삭제 할때 비밀번호 틀린거 글씨 띄워주는곳
	$(function(){
		$("#pwRes").hide();
		
	});
	
	// 비밀번호에 숫자만 입력되게
	$("#pw").keyup(function(event){
	    var inputVal = $(this).val();
	    $(this).val(inputVal.replace(/[^0-9]/gi,''));
	});
	// 수정 버튼 누를때 ajax
	function pwChk(){
		var myboardpw = $("#pw").val().trim();
		var myno = $("#myno").val();
		var boardVal = {
				"myno" : myno,
				"myboardpw" : myboardpw
		}
		
		if(pw == null || pw == ""){
			$("#pwRes").show();
			$("#pwRes").html('게시물 비밀번호를 입력해 주세요.');
			$("#pwRes").css("color", "red");
		} else {
			$.ajax({
				type : "post",
				url : "pwChk.do",
				data :JSON.stringify(boardVal),
				contentType:"application/json",
				dataType:"json",
				success : function(msg) {
					if(msg.check == true){
						location.href='update.do?myno=${dto.myno }';
					} else {
						$("#pwRes").show();
						$("#pwRes").html("PW가 잘못되었습니다.");
						$("#pwRes").css("color", "red");
					}
				},
				error:function(){
					alert("통신 실패");
				}
			});
		}
	}
	// 삭제버튼 누를때 ajax
	function pwChk2(){
		var myboardpw = $("#pw").val().trim();
		var myno = $("#myno").val();
		var boardVal = {
				"myno" : myno,
				"myboardpw" : myboardpw
		}
		if(pw == null || pw == ""){
			$("#pwRes").show();
			$("#pwRes").html('게시물 비밀번호를 입력해 주세요.');
			$("#pwRes").css("color", "red");
		} else {
			$.ajax({
				type : "post",
				url : "pwChk.do",
				data :JSON.stringify(boardVal),
				contentType:"application/json",
				dataType:"json",
				success : function(msg) {
					if(msg.check == true){
						location.href='delete.do?myno=${dto.myno }';
					} else {
						$("#pwRes").show();
						$("#pwRes").html("PW가 잘못되었습니다.");
						$("#pwRes").css("color", "red");
					}
				},
				error:function(){
					alert("통신 실패");
				}
			});
		}
	}
	
	function onclickUpdateComment( index ){
	      if($(".updatetext").eq(index).hasClass("on")){
	          $(".updatetext").eq(index).removeClass("on");
	      }else{
	          $(".updatetext").eq(index).addClass("on");
	      }
	         
	      const clicked = $(".btn-update").eq(index);
	      clicked.html(clicked.html() == '수정' ? '수정 취소' : '수정')
	   }
	   
	   function onClickAnswerComment (index){
	      
	      if($(".answertext").eq(index).hasClass("on")){
	          $(".answertext").eq(index).removeClass("on");
	          $(".comment").eq(index).addClass("on");
	      }else{
	          $(".answertext").eq(index).addClass("on");
	          $(".comment").eq(index).removeClass("on");
	      }
	         
	      const clicked = $(".btn-answer").eq(index);
	      clicked.html(clicked.html() == '답글달기' ? '답글달기 취소' : '답글달기')
	   }
	
	</script>
</body>
</html>