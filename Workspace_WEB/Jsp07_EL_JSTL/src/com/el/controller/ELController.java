package com.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.dto.Score;


@WebServlet("/ELController")
public class ELController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ELController() {
        System.out.println("생성!");
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");
		
		if(command.equals("el")) {
			response.sendRedirect("basic-arithmetic.jsp");
		} else if (command.equals("eltest")) {
			Score score = new Score("홍길동", 100, 100 , 100);
				
			request.setAttribute("score", score);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("eltest.jsp");
			dispatch.forward(request, response);
		} else if (command.equals("jstl")) {
			List<Score> list = new ArrayList<Score>();
			
			for (int i = 10; i < 50; i +=10) {
				Score sc = new Score("이름"+i, 50+i, 50+i, 50+i);
				list.add(sc);
			}
			
			request.setAttribute("list", list);
			RequestDispatcher dispatch = request.getRequestDispatcher("jstltest.jsp");
			dispatch.forward(request, response);
		} else if (command.equals("usebean")) {
			response.sendRedirect("usebean.jsp");
		}
		
	}

}
