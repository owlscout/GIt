package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * Servlet implementation class BikeController
 */
@WebServlet("/BikeController")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		if(command.equals("view")) {
			response.sendRedirect("view.html");
		} else if (command.equals("getdata")) {
			BikeDao dao = new BikeDao();
			
			if(dao.delete()) {
				System.out.println("db 초기화 성공");
			} else {
				System.out.println("db 초기화 실패");
			}
			
			String data = request.getParameter("mydata");
			// JsonElement는 JsonObject, JsonPrimitive, JsonArray, JsonNull  값들을 모두 포함
			JsonElement element = JsonParser.parseString(data); //json형태의 문자열을 json 객체로 변환 (string -> json object)
			// JsonObject : key - value pair ({"String" : JsonElement} 형식)
			JsonObject jsonData = element.getAsJsonObject();    // element의 json의 오브젝트를 jsonData에 넣는다
			// JsonElement는 JsonObject, JsonPrimitive, JsonArray, JsonNull 이 4가지의 부모 클래스로 추상클래스로 정의된다.
			// 4가지중 1개인데 뭔지 모르니 element로 받고 그걸 object로 바꾸고 넣는것이다.
			// JsonObject jsonData = Json Parser.parseString(data).getAsJsonOPbject();
			
			JsonElement records = jsonData.get("records"); 
			// bike.json에서 가져온다 거기에 array로 존재하니까
			JsonArray recordsArray = records.getAsJsonArray(); 
			// JsonArray 변수2 = 변수1.getAsJsonArray()로 어레이를 가져오는것이다
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			JsonArray resultArray = new JsonArray(); // 배열 선언
			
			for (int i = 0; i < recordsArray.size(); i++) { // 0번지 {}로 되어있으니 Object이다.
				/*
				 JsonElement tempElement = recordsArray.get(i);
				 JsonObject TempObject = tempElement.getAsJsonObject();
				 JsonElement name Element = tempObject.get("자전거대여소명");
				 String name = nameElement.getAsString();
				 이렇게 4줄이 바로밑에  	String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				 한줄을 적은것이다.
				*/
				String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				String addr = null;
				if(recordsArray.get(i).getAsJsonObject().get("소재지도로명주소") != null) {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지도로명주소").getAsString();
				} else {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지지번주소").getAsString();
				}
				
				double latitude = recordsArray.get(i).getAsJsonObject().get("위도").getAsDouble();
				double longitude = recordsArray.get(i).getAsJsonObject().get("경도").getAsDouble();
				
				int bike_count = recordsArray.get(i).getAsJsonObject().get("자전거보유대수").getAsInt();
				
				BikeDto dto = new BikeDto(name, addr, latitude, longitude, bike_count);
				list.add(dto);
				
				Gson gson = new Gson(); // 자바 오브젝트를 쉽게 JSON으로 변환 구글에서만든 라이브러리
				String jsonString = gson.toJson(dto); // 인스턴스가 가리키는 문자열을 반환 
				resultArray.add(JsonParser.parseString(jsonString)); // jsonString 을 문자열로 변환하고 json으로 변환한걸 추가
				//gson이 자바 객체를 json객체로 바꾼다음에 json array로 저장시킨것이다.		
			}
			
			if (dao.insert(list)) {
				System.out.println("db 저장 성공");
			} else {
				System.out.println("db 저장 실패");
			}
			
			JsonObject result = new JsonObject(); //gson 으로 json object로 바뀐걸 
			result.add("result", resultArray); // "result"에 array인 값들을 넘을것이다. 
			
			response.getWriter().append(result+"");
			
			
		}
		
	}

}
