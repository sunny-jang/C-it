package com.cit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cit.board.model.BoardDto;
import com.cit.board.service.BoardListService;
import com.cit.member.service.MemberService;
import com.cit.member.service.MyPageMainService;

@WebServlet("/Mypage.do")
public class MyPageMainController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("p"); 
	
		int page_ = 1;
		if(page!=null && !page.equals("")) {
			page_ = Integer.parseInt(page);
		}
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
			dispatcher.forward(request, response);	
		}
		
		MyPageMainService mms = new MyPageMainService();
		ArrayList<BoardDto> myList = mms.getMyList(id);
		request.setAttribute("myList", myList);
		
		int maxPage = myList.size()/5;
		request.setAttribute("maxPage", maxPage);
		
		int[] listSizeSet = setListSize(page_, 5, myList.size()); 
		
 		ArrayList<BoardDto> myList_ = makeList(myList, listSizeSet);
		
		request.setAttribute("myList", myList_);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/myPageMain.jsp");
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
	
	public int[] setListSize(int pageNum, int listLength, int MaxSize) {	
	
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
