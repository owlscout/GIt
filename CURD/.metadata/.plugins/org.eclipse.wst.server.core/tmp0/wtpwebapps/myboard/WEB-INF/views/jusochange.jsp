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
<input type="hidden" name="chk" value="${chk }">
<input type="hidden" id="addname" name="addname" value="">
		<table>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<th colspan="4"><input type="button" value="신규 주소 등록" onclick="goPopup();"></th>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>
						<c:forEach items="${list }" var="ldto" varStatus="status">
						<input type="hidden" class="postno" value="${ldto.addrno }">
						<input type="button" value="${ldto.addname }" onclick="chageaddr(${status.index});">&emsp;&emsp;
						</c:forEach>
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
			<tr>
				<td>
					<input type="button" value="주소 교체" onclick="jusochange()">
					<input type="button" value="취소" onclick="window.close();">
				</td>
			</tr>
		</table>


<script type="text/javascript">
	function chageaddr(index){
		var addrno = $(".postno").eq(index).val();
		$.ajax({
			type : "post",
			url: "addrfind.do",
			data: addrno,
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
			success:function(json){
					var address = json.address_1 + " " + json.address_2;
						$("#addno").val(json.addno);
						$("#addr").val(address);
						$("#addname").val(json.addname);
					
				
			}, error: function(){
				alert("통신실패");
			}
		});
	}

	function jusochange(){
		var addno = $("#addno").val();
		var addr = $("#addr").val();
		var addname = $("#addname").val();
		
		if(addno == null || addno == ""){
			alert("주소를 선택하고 클릭해주세요");
		} else {
			$(opener.document).find("#addno").val(addno);
			$(opener.document).find("#addr").val(addr);
			$(opener.document).find("#addname").val(addname);
			/* console.log("addno", addno);
			console.log("addr", addr);
			console.log("addname", addname);
			opener.jusoBack(addno, addr, addname); */
			window.close();
		}
	}
	
	

</script>
</body>
</html>