<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<table>
		<tr>
			<td>
				<div class="d-flex justify-content-end">
					<button type="button" class="btn btn-info" onClick="goPopup();">주소검색</button>
				</div>
				<!-- 1. 전체 주소 2. 우편번호 3.도로명주소 4.건물명 5. 나머지 주소 -->
				<input type="text" name="address" id="address" class="form-control" placeholder="도로명 주소를 입력해 주세요" required readonly />
				<input type="text" name="zipNo" id="zipNo" class="form-control" placeholder="우편 번호" required readonly><br/>
				<input style="width: 300px;" type="text" name="addr" id="addr" class="form-control" placeholder="도로명 주소를 입력해 주세요" required readonly />
				<input  type="text" name="addr2" id="addr2" class="form-control" placeholder="참고 주소" required readonly /><br/>
				<input type="text" name="addrDetail" id="addrDetail" class="form-control" placeholder="나머지 주소를 입력해 주세요"/>
				<input style="width: 300px;" type="text" name="address" id="address" class="form-control" readonly="readonly" onclick="goPopup();" >
			<td>
		</tr>
	</table>
	<script>
	
	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		// scrollbars=yes 스크롤 바 가능 resizable=yes 팝업창 크기 조절 가능 
		var pop = window.open("signup/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");
	}
	// 값 불러와서 id가 address...등에 각 값에 넣고 나머지 주소가 30글자보다 크면 너무길다고 리턴
	var jusoCallBack = function(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo){ 
		document.getElementById("address").value = roadFullAddr; 
		document.getElementById("zipNo").value = zipNo; 
		document.getElementById("addr").value = roadAddrPart1; 
		document.getElementById("addr2").value = roadAddrPart2;
		roadAddrPart1 += roadAddrPart2;
		if(addrDetail.length>30){ 
			alert('나머지 주소가 너무 길어 다시 입력해야 합니다.'); 
			return; 
		} 
		document.getElementById("addrDetail").value = addrDetail; 
	}
	</script>	
</body>
</html>