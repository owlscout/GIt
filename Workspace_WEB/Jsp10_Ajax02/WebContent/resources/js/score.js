

function getParameterValues(){
	var name = "name=" + encodeURIComponent(document.getElementById("name").value);
	var kor ="kor=" + document.getElementById("kor").value;
	var eng ="eng=" + document.getElementById("eng").value;
	var math ="math=" + document.getElementById("math").value;
	
	return "?" + name + "&" + kor + "&" + eng + "&" + math;
	
}

function load(){
	var url = "score.do" + getParameterValues();
	
	httpRequest = new XMLHttpRequest();//XHR	// server와 통신하는 것을 도와주는 객체  js 꺼고 sqXHR - jq 이다.
	httpRequest.onreadystatechange=callback;	// 처리할 함수 readystate가 변경되는 이벤트가 발생할때마다 callback함수를 호출할꺼야 callback 함수는 바로 실행하는게아니라 특정 무슨 상황에서 필요할때 요청할것이다.
	httpRequest.open("GET", url, true);			// 겟방식으로 url과 연결할 준비 true : 비동기 / false : 동기
	httpRequest.send();							//  get : send() / post : send("data")
}

function callback(){
	alert("readystate : " + httpRequest.readyState);
	// readytState == 4 통신이 완료 되었다면
	if(httpRequest.readyState == 4){
		alert("status : " + httpRequest.status);
		// 통신이 성공적으로 완료되었다면.
		if(httpRequest.status == 200){
			// responseText : 요청 후 응답받은 문자열
			var obj = JSON.parse(httpRequest.responseText);
			document.getElementById("result").innerHTML = decodeURIComponent(obj.name) + "의 총점 : " + obj.sum +
			"\n평균 : " + obj.avg;
		} else{
			alert("통신 실패");
		}
	}
}

/*
	XMLhttpRequest : javascript object. http 를 통한 데이터 수송신 지원
	
	<onreadystatechange>
	0: unitialized - 실행(load)되지 않음
	1: loading - 로드 중
	2: loaded - 로드 됨
	3: interactive - 통신 됨
	4: complete - 통신 완료 
	
	- status
	200 : 성공
	400 : bad request
	401: unauthorized
	403: forbidden
	404: not found 경로 오류
	415: unsupported media type
	500: internal server error 
	
	**
	encodeURIComponent //문자 대부분을 모두 인코딩(UTF-8) // 인코딩은 문자를 컴퓨터에 저장하거나 통신에 사용할 목적으로 부호화하는 방법
	decodeURIComponent // 문자 대부분을 모두 디코딩 // 디코딩은 문자를 원래대로 되돌리는것
	encodeURI : 주소 줄에서 사용되는 특수문자는 제외하고 인코딩
	
	JSON.parse : json형태의 문자열을 json 객체로 변환 (string -> json object) 
	//디비에서 받은 데이터를 쓸때
	// parse(받아온 데이터(필수), 받고서 커스텀하고싶으면 (콜백함수))
	// 1. 변수 : XHR 또는 JQUERY로 data를 할받 받은 변수를 string 에서 이쁘게 객체로 변환 시켜야 쓸 수 있다.
	// 2. 콜백함수 : 비교문 if에서 (value=="boolean" 또는 반복문에서 newBoolean()을 하고있는걸 고쳐주는것이다.)
	JSON.stringify javascript 객체(json 형태로 변환할 수 있는)를 json 형태의 문자열로 변환 (object -> json string)  
	//디비로 데이터를 줄때
	// stringify (보내고 싶은 아무 데이터나 넣어주세요(필수), 있어도 없어도 됨(콜백 함수))
	// 1. 보내야 할 데이터 : 디비에 데이터 변환해서 보내는것이라 아무것도 안넣어주는건 안된다.
	// 2. 콜백함수의 역할은 데이터를 편집하기 위한것 
	
*/

