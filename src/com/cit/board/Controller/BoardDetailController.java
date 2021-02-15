package com.cit.board.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.model.BoardDto;
import com.cit.board.service.BoardDetailService;

@WebServlet("/BoardDetail.do")
public class BoardDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
	
		BoardDetailService bds = new BoardDetailService();
		BoardDto BDetail = bds.getBoard(num);
		request.setAttribute("BoardDetail", BDetail);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/boardView.jsp");
		dispatcher.forward(request, response);
		
	
		
	}
}
