package com.cal.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cal.dto.CalDto;

public class Util {
	
	private String todates;
	
	public String getTodates() {
		return todates;
	}
	public void setTodates(String mdate) {
		//yyyy-MM-dd hh:mm 00 형태로 바꾸자/
		String temp = mdate.substring(0, 4)+"-"
					+ mdate.substring(4, 6)+"-"
					+ mdate.substring(6, 8)+" "
					+ mdate.substring(8, 10)+":"
					+ mdate.substring(10)+":00";
		// 자신이 원하는 날짜의 포맷을 지정할수 있게 한다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분"); 
		//자바에서 Timestamp를 이용해 현재 시간을 구할 수 있는데 Date를 이용한 방법과의 차이는 Date는 Millisecond까지 구할 수 있지만 Timestamp는 Millisecond에 Nanosecond까지 구할 수 있다
		Timestamp tm = Timestamp.valueOf(temp);
		todates = sdf.format(tm);
	}
	
	// 토요일, 일요일, 평일 색상
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		//dayOfWeek 1 : 일요일 2:월요일  
		if((dayOfWeek - 1 + date)%7 == 0) {
			color = "blue";
		} else if ((dayOfWeek - 1 + date)%7 == 1) {
			color = "red";
		} else {
			color = "black";
		}
		
		return color;
	}
	
	// 일정의 한자리수 -> 두자리수 변환
	public static String isTwo(String msg) {
		//삼항 연산자
		return (msg.length()<2)?"0"+msg : msg;
	}
	
	// 일정 제목이 긴 경우, 뒷부분을 ...으로 
	public static String getCalView(int i, List<CalDto> list) {
		String d = isTwo(i+"");
		String res = "";
		//for(변수타입 변수이름:배열이름)
		// 		실행부분;
		for (CalDto dto : list) { // dto의 mdate에서의 6~8-1위치까지 출력 
			if (dto.getMdate().substring(6, 8).equals(d)) {
				res += "<p>"
						+ ((dto.getTitle().length() > 6)? dto.getTitle().substring(0, 6)+"..." : dto.getTitle())
						+ "</p>";
			}
		}
		
		return res;
	}
	
	
}
