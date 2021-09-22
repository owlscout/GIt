package com.scope.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ScopeController")
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		/*
		 1 request				2 request		1번 request에 담겨져있는데 2번 request에게 값을 달라고 요청해서 null값이 나온다.
index.jsp <ㅡ>   	servlet  	<ㅡ> result.jsp		각 jsp에서 요청하는게 request 에 담겨져있는데 요구하는건 같은 글이지만 서로 다른 객체이다. index에서 값을 넣어준 request를 요청한게아니기때문에 null이다.
		 1respon				2respon		
		 */
		String requestId = request.getAttribute("requestId") + "";
		
		HttpSession session = request.getSession();
		String sessionId = session.getAttribute("sessionId") + "";
		
		ServletContext application = getServletContext();
		String applicationId = application.getAttribute("applicationId") + "";
		
		System.out.println("requestId : " + requestId);
		System.out.println("sessionId : " + sessionId); 
		System.out.println("applicationId : " + applicationId);
		// form 태그 사용해서 servlet에 전달해줬기에
		// getParameter 로 전달해준걸 받아서 쓰는거라 null이아닌 값이 나온다
		String myRequest = request.getParameter("myRequest");
		System.out.println("myRequest : " + myRequest);
		
		PrintWriter out = response.getWriter();
		String html = "<h1>응답</h1>"
				+ "<table border='1'>"
					+ "<tr>"
						+ "<th>request</th>"
						//+ "<td>" + requestId +"</td>"
						+ "<td>" + myRequest + "</td>"
					+ "</tr>"
					+ "<tr>" 
						+ "<th>session</th>"
						+ "<td>" + sessionId + "</td>"
					+ "</tr>"
					+ "<tr>"
						+ "<th>application</th>"
						+ "<td>" + applicationId + "</td>"
					+ "</tr>"    
				+ "</table>";
		out.print(html);
		
		// 이거 적었을때 뜨는건 forward 로 했기에 위임해서 나올 수 있게된것이다.
		request.setAttribute("myRequest", "servlet에서 보냄");
		// 서블릿에서 값을 넘겨주고 해당 페이지에서 처리할 수 있도록 하는 방법
		// request 와 reponse 를 전달
		RequestDispatcher dispatch = request.getRequestDispatcher("result.jsp");
		dispatch.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
