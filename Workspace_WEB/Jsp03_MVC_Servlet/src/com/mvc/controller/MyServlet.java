package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBoardBiz;
import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MVCBoardBiz biz = new MVCBoardBizImpl();
		
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");
		
		if (command.equals("list")) {
			//1. 보내준 값 있으면 받기
			
			//2. db호출(전달할 값 있으면 전달)
			List<MVCBoardDto> list = biz.selectList();
			//3. 화면에 보내줄 값 있으면 request객체게 담기 
			request.setAttribute("list", list);
			//4. 보내기
			dispatch(request, response, "mylist.jsp");
			
		} else if(command.equals("insertform")) {
			// 1. 
			// 2.
			// 3.
			// 4.
			response.sendRedirect("myinsert.jsp");
			
		} else if(command.equals("insertres")) {
			// 1.
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// 2.
			MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
			int res = biz.insert(dto);
			// 3.
			// 4.
			
			if(res>0) {
				// 이렇게 쓰면 f5누르면 계속 글이 작성된다
				//request.setAttribute("list", biz.selectList());
				//dispatch(request, response, "mylist.jsp");
				response.sendRedirect("myservlet.do?command=list");
			} else {
				response.sendRedirect("myservlet.do?command=inertform");
			}
			
		} else if (command.equals("selectone")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCBoardDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "myselect.jsp");
			
		} else if (command.equals("updateform")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCBoardDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "myupdate.jsp");
			
		} else if (command.equals("updateres")) {
			// 1. 보내준 값을 받는다.
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			// 2. db에 보낼꺼 있으면 보낸다.
			//MVCBoardDto dto = new MVCBoardDto(seq, null, title, content, null);
			MVCBoardDto dto = new MVCBoardDto();
			dto.setSeq(seq);
			dto.setTitle(title);
			dto.setContent(content);
			// 3.
			// 4.
			int res = biz.update(dto);
			
			if(res > 0) {
				response.sendRedirect("myservlet.do?command=selectone&seq="+ seq);
			} else {
				response.sendRedirect("myservlet.do?command=insertform&seq=" + seq);
			}
			
		} else if (command.equals("deleteform")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = biz.delete(seq);
			
			if(res > 0) {
				response.sendRedirect("myservlet.do?command=list");
			} else {
				response.sendRedirect("myservlet.do?command=selectone&seq=" + seq);
			}
				
		}
		
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		
	}
	
	
	
}
