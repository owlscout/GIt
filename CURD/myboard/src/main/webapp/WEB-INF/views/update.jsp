<%@page import="com.mvc.myboard.userDto"%>
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

	<form action="updateres.do" method="post">
		<input type="hidden" name="myno" value="${dto.myno }">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td>${dto.myname }</td>
			</tr>
			<tr>
				<th>제목</th>				
				<td><input type="text" name="mytitle" maxlength="30" value='${dto.mytitle }' placeholder="50자까지 작성 가능합니다"></td>
			</tr>	
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="60" id="mycontent" name="mycontent" placeholder="1000byte까지 작성 가능합니다">${dto.mycontent }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right" id="textlength">0/1000byte
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="글수정">
					<input type="button" value="취소" onclick="history.go(-1); return false;">
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
	$("#mycontent").keyup(function(){
		// 총 바이트 값
		var totalByte = 0;
		// 정해진 값 넘어가면 저장할 글자
		var saveMsg = "";
		// 현재 입력된값
		var message = $("#mycontent").val();
		// 1000byte넘으면 맨뒷글 잘라서 저장할 변수
		var msgLength = 0;
		//현재 작성된 글 만큼 for문 반복
		console.log(totalByte)
		for(var i =0; i < message.length; i++) {
			// 해당 글자의 code를 가져온다
			var currentByte = message.charCodeAt(i);
			// 한글은 2자, 그외는 1자를 추가해준다
			if(totalByte < 1000){
				if(currentByte > 128){
					totalByte += 2;
					msgLength++;
					$("#textlength").html(totalByte + '/1000byte');
				} else { 
					totalByte++;
					msgLength++;
					$("#textlength").html(totalByte + '/1000byte');
				}
			} else if(totalByte >= 1000){
				var subLength = message.length - msgLength;
				saveMsg = message.substring(0, message.length-subLength)
				$("#mycontent").val(saveMsg);
				alert("1000byte를 넘길 수 없습니다.")
				break;
			}
			
		}
	});
	</script>
</body>
</html>