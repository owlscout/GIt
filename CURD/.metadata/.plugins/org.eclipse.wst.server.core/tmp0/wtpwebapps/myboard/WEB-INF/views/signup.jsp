<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

	<h1>회원가입</h1>
	
	<form action="signupres.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userid" id="id" onkeyup = "checkId();"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="idChkres"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="userpw" id="pw" placeholder="영문 + 숫자 + 특수문자 7~16글자로해주세요" onkeyup="checkPwd1();"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="pwChkres"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" id="pwChk" placeholder="비밀번호 확인" onkeyup="checkPwd2();"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="pwChkres2"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" id="address" readonly="readonly" placeholder="주소를 입력하려면 여기를 클릭하세요" onclick="goPopup();">
					<input type="hidden" name="address_1" id="addr_1" readonly="readonly">
					<input type="hidden" name="address_2" id="addr_2" readonly="readonly">
					<input type="hidden" name="addno" id="addrno" readonly="readonly">
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="회원가입">
					<input type="button" value="취소" onclick="history.back();">
				</td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
$(function() {
	$("#idChkres").hide();
	$("#pwChkres").hide();
	$("#pwChkres2").hide();
});
	
	function checkId(){
		var id = $("#id").val().trim();
		$("#id").val(id.replace(/[^a-zA-Z0-9]/gi, ''));
		var userid = $("#id").val().trim();
		if(userid == null || userid == ""){
			$("#idChkres").show();
			$("#idChkres").html('ID를 입력해 주세요.');
			$("#idChkres").css("color", "red");
		} else {
			$.ajax({
				type : "post",
				url : "ajaxidChk.do?userid=",
				data : userid,
				contentType : "application/text",
				dataType : "text",
				success : function(check) {
					$("#idChkres").show();
					if (check == "false") {
						$("#idChkres").html('사용 가능한 ID입니다.');
						$("#idChkres").css("color", "blue");
						console.log(userid)
						
					} else {
						$("#idChkres").html('이미 존재하는 ID입니다.');
						$("#idChkres").css("color", "red");
						
					}
				},
				error : function(){
					alert("ID 통신 실패");
				}
			});
		}
		
		
		
	}

	function checkPwd1(){
		var pw = $("#pw").val().trim();
		
		var pattern1 = /[0-9]/;
	
	    var pattern2 = /[a-zA-Z]/;
	
	    var pattern3 = /[~!@\#$%<>^&*]/;
		
	    if(!pattern1.test(pw)||!pattern2.test(pw)||!pattern3.test(pw)||pw.length<7||pw.length>16){
	    	$("#pwChkres").show();
			$("#pwChkres").html('영어 + 숫자 + 특수문자 넣어서 7~ 16자로 적어주세요');
			$("#pwChkres").css("color", "red");
            return false;

        } else {
        	$("#pwChkres").hide();
        }        
	}
	
	function checkPwd2(){
		var pw = $("#pw").val().trim();
		var pwChk = $("#pwChk").val().trim();
		
		if(pw != pwChk){
			$("#pwChkres2").show();
			$("#pwChkres2").html('비밀번호가 불일치합니다');
			$("#pwChkres2").css("color", "red");
		} else {
			$("#pwChkres2").show();
			$("#pwChkres2").html('비밀번호가 일치합니다');
			$("#pwChkres2").css("color", "blue");
		}
	}
	
	
	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		// scrollbars=yes 스크롤 바 가능 resizable=yes 팝업창 크기 조절 가능 
		var pop = window.open("resources/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadFullAddr, roadAddrPart1, roadAddrPart2, zipNo, addrDetail, inputYn, admCd, rnMgtSn, bdMgtSn){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.	
		document.getElementById("address").value = roadFullAddr;
		document.getElementById("addr_1").value = roadAddrPart1;
		document.getElementById("addr_2").value = roadAddrPart2;
		document.getElementById("addrno").value = admCd;
		

	}
	

</script>
</body>
</html>