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
<body>

	<form action="mulorderres.do" method="post">
		<input type="hidden" name="chk" value="${chk }">
		<input type="hidden" id="addname" name="addname" value="${dto.addname }">
		<input type="hidden" name="address_1" id="addr_1" value="${dto.address_1 }" readonly="readonly">
		<input type="hidden" name="address_2" id="addr_2" value="${dto.address_2 }" readonly="readonly">
		<input type="hidden" name="addno" id="addrno" value="${dto.addno }"  readonly="readonly">
		<input type="hidden" name="mainaddr" id="mainaddr" value="N" readonly="readonly">
		<table border="1">
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4"><input type="button" value="신규 주소 등록" onclick="goPopup();"></th>
				</tr>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td>
						<input type="radio" id="select1" value="기존 주소지" checked>
  						<label for="select1">기존 주소지사용</label>
					</td>
					<td>
						<input type="radio" id="select2" value="새 주소지" >
  						<label for="select2">새 주소지</label>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<c:forEach items="${list }" var="ldto" varStatus="status">
						<input type="hidden" class="postno" value="${ldto.addrno }">
						<input type="button" value="${ldto.addname }" onclick="chageaddr(${status.index});">&emsp;&emsp;
						</c:forEach>
						<input type="button" value="주소불러오기" onclick="jusochange();">
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
			
			<tr class="mainaddr">
				<th>우편번호</th>
				<td><input type="text" id="addno" value="${dto.addno }" readonly="readonly"></td>
			</tr>
			<tr class="mainaddr">
				<th>주소</th>
				<td><input type="text" id="addr" value="${dto.address_1}&emsp;${dto.address_2}" readonly="readonly"></td>
			</tr>
			
			<tr align="center">
				<td colspan="2">
					<input type="checkbox" id="check" onchange="checkBox(this);" >
					<label for="check1"><span>메인주소로 등록하시겠습니까?</span></label>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="결제하기">
					<input type="button" value="장바구니" onclick="location.href='cartlist.do'"><br>
				</td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
	
	
	$(document).ready(function(){
		    $("input:radio[id=select2]").click(function(){
		    	goPopup();
		    })
		    
		    $("input:radio[id=select1]").click(function(){
				$(".newaddr").hide();
				$(".mainaddr").show();
			})
				    
		});
	
	function chageaddr(index){
		var addrno = $(".postno").eq(index).val();
		console.log(addrno);
		$.ajax({
			type : "post",
			url: "addrfind.do",
			data: addrno,
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success:function(json){
					var address = json.address_1 + " " + json.address_2;
						$("addr_1").val(json.address_1);
						$("addr_2").val(json.address_2);
						$("#addno").val(json.addno);
						$("#addr").val(address);
						$("#addname").val(json.addname);
					
				
			}, error: function(){
				alert("통신실패");
			}
		});
	}
	
	function namewrite(addname){
		$("#addname").val(addname);
	}
	
	function jusochange(){
		
		var pop = window.open("jusochange.do","pop","width=570,height=420, scrollbars=yes, resizable=yes");
	}
	
	function jusoBack(addno, address, addname){
		$("#addno").val(json.addno);
		$("#addr").val(address);
		$("#addname").val(json.addname);
		console.log("addno", addno);
		console.log("addr", addr);
		console.log("addname", addname);
		document.getElementById("addno").value = addno;
		document.getElementById("addr").value = addr;
		document.getElementById("addrname").value = addname;
	}

	function goPopup() {
		$(".newaddr").show();
		$(".mainaddr").hide();
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		// scrollbars=yes 스크롤 바 가능 resizable=yes 팝업창 크기 조절 가능
		var pop = window.open("resources/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
	
	function jusoCallBack(roadFullAddr, roadAddrPart1, roadAddrPart2, zipNo, addrDetail, inputYn, admCd, rnMgtSn, bdMgtSn){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.	
		document.getElementById("addr").value = roadFullAddr;
		document.getElementById("addr_1").value = roadAddrPart1;
		document.getElementById("addr_2").value = roadAddrPart2;
		document.getElementById("addrno").value = admCd;
		
	
	}
	
	function checkBox(chk){
		if(chk.checked == true){
			$("#mainaddr").val("Y");
			console.log($("#mainaddr").val())
		} else{
			$("#mainaddr").val("N");
			console.log($("#mainaddr").val())
		}
	}

</script>
</body>
</html>