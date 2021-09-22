package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
// Web.xml 설정을 annotation으로 간략화 		 web.xml에서의 
@WebServlet("/controller.do") // webservelt 은 <servlet>이 감싼것들을 간략화
			// controller.do 는 <servlet-mapping>이 감싼것들을 간략화 한것이다 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String initParam;
	private String contextParam;
	
    public HelloServlet() {
       System.out.println("servlet constructor");
       
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("servlet init");
    	
    	contextParam = config.getServletContext().getInitParameter("name");
    	initParam = config.getInitParameter("sports");
    	System.out.println("context-param : " + contextParam);
    	System.out.println("init-param : " + initParam);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // get 방식으로 들어온 요청을 처리해준다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("Get 방식으로 들어옴!");
		// form 태그에서 method="post" 지정안하면 무조건 get방식
		
		// 1.
		String command = request.getParameter("command");
		System.out.println("command" + command);
		// 2.
		
		// 3.
		
		// 4.
		PrintWriter out = response.getWriter(); // 
		out.print("<h1 style='color: red'>Hello Serrvlet</h1>");
		out.print("<h2>계층구조, lifecycle, url-mapping</h2>");
		out.print("<a href='home.html'>home...</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// post 방식으로 들어온 요청을 처리해준다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charser=UTF-8");
		System.out.println("Post 방식으로 들어옴!");
		
		// 1.
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		// 2.
		
		// 3.
		
		// 4.
		PrintWriter out =  response.getWriter();
		out.print("<h1 style='color: blue'>Hellow Servlet</h1>");
		out.print("<h2>init - service - doGet/doPost - destroy</h2>");
		out.print("<a href='home.html'>home...</a>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy");
	}
	
	
	
}
