package com.cit.board.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.model.BoardDto;
import com.cit.board.service.BoardService;

@WebServlet("/board.do")
public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO bdto 사용하는 곳 없으면 삭제
		BoardDto bdto = new BoardDto();
		
		BoardService bs = new BoardService();
		ArrayList<BoardDto> list = bs.List();
		request.setAttribute("list", list);
		System.out.println(list.toString());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/board.jsp");
		dispatcher.forward(request, response);
		
	}
}
