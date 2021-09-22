
$(function(){
	getJsonData();
});

function getJsonData(){
	$.getJSON("resources/json/bike.json", function(mydata){ //bike.json에서 가져온값을 mydata이다. // getJSON은 데이터타입이 json인 ajax 인것이다.
		$.ajax({
			url: "bike.do", // 전송할 서버
			method: "post",  // post방식으로 method를 보낼꺼야
			data: {"command": "getdata", "mydata": JSON.stringify(mydata)}, //javaScript 값이나 객체를 JSON 문자열로 변환합니다
			dataType: "json", // 통신이 성공하면 리턴받을 data의 type 
			success: function(msg){
				var $tbody = $("tbody");
				
				var list = msg.result;
				for (var i = 0; i < list.length; i++){
					var $tr = $("<tr>");
					
					$tr.append($("<td>").append(list[i].name));
					$tr.append($("<td>").append(list[i].addr));
					$tr.append($("<td>").append(list[i].latitude));
					$tr.append($("<td>").append(list[i].longitude));
					$tr.append($("<td>").append(list[i].bike_count));
					
					$tbody.append($tr);
				}
			},
			error: function(){
				alert("통신 실패");
			} 
		});
	});
}