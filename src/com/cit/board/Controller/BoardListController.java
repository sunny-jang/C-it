package com.cit.board.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.model.BoardDto;
import com.cit.board.service.BoardListService;

@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("p"); 
		int page_ = 1;
		if(page!=null && !page.equals("")) {
			page_ = Integer.parseInt(page);
		}
		
		BoardListService bs = new BoardListService();
		ArrayList<BoardDto> list = bs.List();
		
		int maxPage = list.size()/3;
		request.setAttribute("maxPage", maxPage);
		
		int[] listSizeSet = setListSize(page_, 3, list.size()); 
		
 		ArrayList<BoardDto> list_ = makeList(list, listSizeSet);
		
		request.setAttribute("list", list_);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/board.jsp");
		dispatcher.forward(request, response);
	}
	
	public static ArrayList<BoardDto> makeList(ArrayList<BoardDto> list, int[] listSizeSet) {	
		ArrayList<BoardDto> list_ = new ArrayList<BoardDto>();
		
		int page = listSizeSet[0];
		int endPoint = listSizeSet[1];
		for(int i= page; i < endPoint; i++) {
			list_.add(list.get(i));
		}
		return list_;
	}
	
	public int[] setListSize(int pageNum, int listLength, int MaxSize) {	// 한 페이지에 나오는 글의 개수
	
		int[] pageSet = new int[2];
		
		int page = pageNum;
		
		page = ((page)-1)*listLength;
		
		int endPoint = page+listLength;
		if(endPoint > MaxSize) {
			endPoint=MaxSize;
		}
		
		pageSet[0] = page;
		pageSet[1] = endPoint;
		
		return pageSet;	
	}
}
