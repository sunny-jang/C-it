package com.cit.news.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.news.model.NewsDao;
import com.cit.news.model.NewsDto;

@WebServlet("/NewsViewController.do")
public class NewsViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsViewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNum = Integer.parseInt(request.getParameter("num"));
		NewsDto ndto = NewsDao.getInstance().getNews(boardNum);
		
		request.setAttribute("news", ndto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/news/news_view.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
