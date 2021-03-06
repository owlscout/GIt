<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" id="userid"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="userpw"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="login" onclick="login();">
				<input type="button" value="signup" onclick="location.href='signup.do'">
				<input type="button" value="취소" onclick="history.back();">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>
	
	<script type="text/javascript">
		$(function(){
			$("#loginChk").hide();
		});
		
		
		function login(){
			var userid = $("#userid").val().trim();
			var userpw = $("#userpw").val().trim();
			
			var loginVal = {
					"userid" : userid,
					"userpw" : userpw
			}
			
			if(userid == null || userid == "" || userpw == null || userpw == ""){
				$("#loginChk").show();
				$("#loginChk").html("아이디 혹은 비밀전호를 입력해 주세요");
			} else {
				$.ajax({
					type:"post",
					url:"ajaxlogin.do",
					data:JSON.stringify(loginVal),
					contentType:"application/json",
					dataType:"json",
					success:function(msg){
						if(msg.check == true){
							location.href="home.do";
						} else {
							$("#loginChk").show();
							$("#loginChk").html("아이디 혹은 비밀번호가 잘못되었습니다.");
						}
					},
					error:function(){
						alert("통신 실패");
					}
				});
			}
			
		}
		
	
	</script>
	
</body>
</html>