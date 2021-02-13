package com.cit.news.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.model.BoardDto;
import com.cit.member.model.MemberDto;
import com.cit.news.service.NewsService;
import com.cit.search.service.SearchService;

@WebServlet("/newscontorller.do")
public class NewsViewController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		BoardDto bdto = new BoardDto();
		
		int num = bdto.getNum();
		String title = bdto.getTitle();
		Date date = bdto.getDate();
		int views = bdto.getViews();
		String cont = bdto.getCont();
		String id = bdto.getId();
		String cate = bdto.getCate();
		int rNum = bdto.getrNum();
		String author = bdto.getAuthor();
		String newsLink = bdto.getNewsLink();
		
		NewsService ns = new NewsService(
				num,
				title,
				date,
				views,
				cont,
				id,
				cate,
				rNum,
				author,
				newsLink
				);
		
		request.setAttribute("list", list);
//		request.setAttribute("num", num);
//		request.setAttribute("title", title);
//		request.setAttribute("date", date);
//		request.setAttribute("views", views);
//		request.setAttribute("cont", cont);
//		request.setAttribute("id", id);
//		request.setAttribute("cate", cate);
//		request.setAttribute("rNum", rNum);
		
		request.getRequestDispatcher("/news/news_main.jsp").forward(request, response);
	}

}
