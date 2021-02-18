package com.cit.board.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.service.BoardService;
import com.cit.notice.service.NoticeService;

@WebServlet("/BoardDel.do")
public class BoardDelController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		BoardService bs = new BoardService();
		bs.delBoard(num);
		
		response.sendRedirect(request.getContextPath() + "/BoardList.do");
	}
}
