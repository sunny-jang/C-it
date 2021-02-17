package com.cit.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.news.controller.NewsListController;
import com.cit.news.model.NewsDto;

/**
 * Servlet implementation class MainViewController
 */
@WebServlet("/MainViewController.do")
public class MainViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<NewsDto> nList = NewsListController.makeList();
		System.out.println(nList.toString());
		request.setAttribute("nList", nList);
		NewsListController.setPage(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/main/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
