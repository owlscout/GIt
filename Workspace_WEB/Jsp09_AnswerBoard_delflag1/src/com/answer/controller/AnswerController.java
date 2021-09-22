package com.answer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.answer.biz.AnswerBiz;
import com.answer.biz.AnswerBizImpl;
import com.answer.dto.AnswerDto;

/**
 * Servlet implementation class controller
 */
@WebServlet("/answer.do")
public class AnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		AnswerBiz biz = new AnswerBizImpl();
		
		String command = request.getParameter("command");
		
		if(command.equals("list")) {
			List<AnswerDto> list = biz.selectList();
			request.setAttribute("list", list);
			dispatch(request, response, "boardlist.jsp");
			
		} else if (command.equals("select")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch(request, response, "boardselect.jsp");
			
		} else if (command.equals("answerform")) {
			int boardno = Integer.parseInt(request.getParameter("boardno"));
			AnswerDto dto = biz.selectOne(boardno);
			request.setAttribute("dto", dto);
			dispatch(request, response, "answerform.jsp");
			
		} else if (command.equals("answerproc")) {
			int parentBoardNo = Integer.parseInt(request.getParameter("parentBoardNo"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			
			AnswerDto dto = new AnswerDto();
			dto.setBoardno(parentBoardNo);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setWriter(writer);
			int res = biz.answerProc(dto);
			if(res>0) {
				jsResponse(response, "answer.do?command=list", "답변 성공");
			} else {
				jsResponse(response, "answer.do?command=answerform&boardno="+parentBoardNo, "답변 실패");
			}
		}
		
	}
	
	private void jsResponse(HttpServletResponse response, String url, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		String s = "<script>alert('"+msg+"');location.href='"+url+"';</script>";
		out.println(s);
	}
	
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	

}
