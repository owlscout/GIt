package com.ncs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		LoginService biz = new LoginService();
		String command = request.getParameter("command");
		
		if(command.equals("login")) {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			
			Member Member = biz.selectOneMember(userId, password);
			
			if(Member != null) {
				session.setAttribute("Member", Member);
				response.sendRedirect("loginSuccess.jsp");
			} else {
				response.sendRedirect("loginFail.jsp");
			}
			
		} else if (command.equals("logout")) {
			HttpSession Member = request.getSession();
			Member.invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
