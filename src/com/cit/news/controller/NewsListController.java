package com.cit.news.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.news.model.NewsDto;
import com.cit.news.service.NewsService;

@WebServlet("/NewsListController.do")
public class NewsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/news/news_main.jsp");
		NewsService ns = new NewsService();
		ArrayList<NewsDto> list = ns.getList();
		
		for(int i=0; i<list.size(); i++) {
			String content = list.get(i).getCont();
			try {
				content = removeTag(content);
				list.get(i).setCont(content);
				System.out.println(content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		list = setCategory(request, response, list);
		setPage(request, response);
		
		request.setAttribute("list", list);
		rd.forward(request, response);
	}
	
	public void setPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String endNum = null;
		if(request.getParameter("pageEnd") != null) {
			endNum = request.getParameter("pageEnd");
			request.setAttribute("endNum", Integer.parseInt(endNum));
		}else {
			request.setAttribute("endNum", 2);
		}
	}
	
	public ArrayList<NewsDto> setCategory(HttpServletRequest request, HttpServletResponse response, ArrayList<NewsDto> list) throws ServletException, IOException {
		if(request.getParameter("category") != null) {
			String paramCategory = request.getParameter("category");
			ArrayList<NewsDto> list_ = new ArrayList<NewsDto>();
			
			for(NewsDto item : list) {
				String category = item.getCate();
				if(paramCategory.equals(category)) {
					list_.add(item);
				}
			}
			
			return list_;
		}
		
		return list;
	}
	
	public String removeTag(String html) throws Exception {
		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
}
