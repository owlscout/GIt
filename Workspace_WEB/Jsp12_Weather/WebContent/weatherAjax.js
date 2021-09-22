$(function() {
	$("#weaView").click(
			function() {
				var url = "weatherOpen";
				var code = $("#address option:selected").val();
				$.ajax({
					type : "GET",
					url : url + "?code=" + code,
					dataType : "text",
					success : function(data) {
						//alert(data);
						var temp = $.trim(data);
						//alert(temp);
						var obj = JSON.parse(temp);
						
						$("#pubDate").val(obj.pubDate);
						$("#temp").val(obj.temp);
						$("#x").val(obj.x);
						$("#y").val(obj.y);
						$("#reh").val(obj.reh);
						$("#pop").val(obj.pop);
						$("#wfKor").val(obj.wfKor);

						var weather_condition = obj.wfKor;
						if (weather_condition == "맑음"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/sun.png");
						}else if (weather_condition == "비"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/rain.png");
						}else if (weather_condition == "눈"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/snow.png");
						}else if (weather_condition == "흐림"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/cloud.png");
						}else if (weather_condition == "구름 조금"){
							$("#weather_img").attr("src","/Jsp12_Weather/image/cloud_sun.png");
						}else{
							$("#weather_img").attr("src","/Jsp12_Weather/image/etc.png");
						}
					},
					error : function() {
						alert("정보를 불러오는데 실패하였습니다.");
					}
				});
			});
});

/*
	weatherInfo.jsp  
	
	jstl : JSP Standard Tag Library 표준 태그 라이브러리
	c: core library 
	x: xml library => apache.xalan 필요
	
	weatherInfo.jsp 
	error가 나면 err에 값을 넣어줄꺼야 
	
	${err} : <c:out ~~>
	<c: set> 값을 저장하는애         weatherURL에 다가 그 밑에 value를 넣어줬다.
	<x: parse > var = wrss객체에 {weather}의 rss 내용을 wrss에 값을 담고 거기서 그 밑에 있는 이름의 것들의 값을 가져오자
	alert을 했을때 trim안하면 공백이있는데 그 이유는 weatherinfo의 pubDate 위에것들 한줄 한줄이 다 엔터형태라서 그래서 공백이 생기는것이다. 
	
*/ 