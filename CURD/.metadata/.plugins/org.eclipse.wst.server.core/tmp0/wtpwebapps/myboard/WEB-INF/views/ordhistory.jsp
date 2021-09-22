<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

	function namesearch(){
		var footer = $(".footer")
		var username = $("#name").val().trim();
		console.log(username)
		if(username == null || username == ""){
			alert("이름을 적고 검색을 눌러주세요")
		} else {
			$.ajax({
					type : "post",
					url : "ordhisname.do?username=",
					data : username,
					contentType : "application/json; charset=UTF-8",
					dataType : "json",
					success : function(json){
						$(".list").children().remove();
						console.log(json[0].ordhisno)
						if(json.length == 0){
							var list = $("<tr>")
							list.addClass("list");
							list.append("<th colspan='5'>--------검색된 내용이 없습니다-----------</th>")
							footer.before(list);
						} else {
							for(var i = 0; i < json.length; i++){
								var list = $("<tr>")
								list.addClass("list")
								list.append("<td>"+ json[i].ordhisno +"</td>");
								list.append("<td>"+ json[i].delno +"</td>");
								list.append("<td>"+ json[i].username +"</td>");
								list.append("<td>"+ json[i].reason +"</td>");
								list.append("<td>"+ json[i].ordhisdate +"</td>");
								
								footer.before(list);
							}
						}
						
					}, error: function(){
						alert("통신실패");
					}
			});
		}
		
	}

</script>
</head>
<body>
	
	<div>
		<div>
			<div>
				<input type="text" size="30" id="name" placeholder="검색할 유저 이름을 쳐주세요">
				<input type="button" value="검색" onclick="namesearch();">
			</div>
			
		</div>
	</div>
	<table border="1">
		<col width="50">
		<col width="120">
		<col width="100">
		<col width="500">
		<col width="150">
		<tr>
			<th>번호</th>
			<th>주문번호</th>
			<th>주문자</th>
			<th>내용</th>
			<th>주문일</th>
		</tr>
		
		<tr class="list">
		</tr>
		<tr class="footer">
			<td>
				<input type="button" value="관리자페이지" onclick="location.href='admin.do'">
			</td>
		</tr>
	</table>
	
</body>
</html>