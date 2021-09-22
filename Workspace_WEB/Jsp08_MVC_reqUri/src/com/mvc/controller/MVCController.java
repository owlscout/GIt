package com.mvc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
 * Servlet implementation class MVCController
 */
@WebServlet(urlPatterns={"/selectlist", "/selectone"})
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MVCBoardBiz biz;

	private void getRequestUri(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/http; charset=UTF-8");
		
		biz = new MVCBoardBizImpl();
		
		String command = request.getRequestURI();
		System.out.println("[" + command + "]");
		
		if(command.endsWith("/selectlist")) {
			doSelectList(request, response);
		} else if (command.endsWith("/selectone")) {
			doSelectOne(request, response);
		}
		
	}
	
	private void doSelectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2.
		MVCBoardDto dto = biz.selectOne(seq);
		// 3.
		request.setAttribute("dto", dto);
		// 4.
		dispatch(request, response, "mvcselect.jsp");
		
	}

	private void doSelectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.
		//2.
		List<MVCBoardDto> list = biz.selectList();
		//3.
		request.setAttribute("list", list);
		//4.
		dispatch(request, response, "mvclist.jsp");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getRequestUri(request, response);
		//doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getRequestUri(request, response);
		/*
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/http; charset=UTF-8");
		
		MVCBoardBiz biz = new MVCBoardBizImpl();
		String command = request.getParameter("command");
		
		if(command.equals("list")) {
			//1.
			//2.
			List<MVCBoardDto> list = biz.selectList();
			//3.
			request.setAttribute("list", list);
			//4.
			dispatch(request, response, "mvclist.jsp");
		} else if (command.equals("select")) {
			//1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2.
			MVCBoardDto dto = biz.selectOne(seq);
			// 3.
			request.setAttribute("dto", dto);
			// 4.
			dispatch(request, response, "mvcselect.jsp");
			
		} else if (command.equals("updateform")) {
			//1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			//2.
			MVCBoardDto dto = biz.selectOne(seq);
			//3.
			request.setAttribute("dto", dto);
			//4.
			dispatch(request, response, "mvcupdate.jsp");
		
		} else if (command.equals("updateres")) {
			//1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			//2.
			MVCBoardDto dto = new MVCBoardDto(seq, null, title, content, null);
			int res = biz.update(dto);
			if(res > 0) {
				// forward를 하면 request가 계속 연결되기때문에 새로고침 시 값이 계속 전달된다.
				response.sendRedirect("mvc.do?command=select&seq="+seq);
			} else {
				response.sendRedirect("mvc.do?command=updateform&seq="+seq);
			}
		} else if (command.equals("delete")) {
			//1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			//2.
			int res = biz.delete(seq);
			//3.
			//4.
			if(res > 0) {
				dispatch(request, response, "mvc.do?command=list");
			} else {
				dispatch(request, response, "mvc.do?command=select&seq="+seq);
			}
			
		} else if (command.equals("insertform")) {
			
			response.sendRedirect("mvcinsert.jsp");
			
		} else if (command.equals("insertres")) {
			//1.
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			//2.
			MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
			int res = biz.insert(dto);
			//3.
			//4.
			if(res > 0) {
				response.sendRedirect("mvc.do?command=list");
			} else {
				response.sendRedirect("mvc.do?command=inserform");
			}
		}
		*/
	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
}
