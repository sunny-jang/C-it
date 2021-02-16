package com.cit.news.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.news.model.NewsDto;
import com.cit.news.service.NewsService;

/**
 * Servlet implementation class NewsWriteController
 */
@WebServlet("/NewsWriteController.do")
public class NewsWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/news/news_write.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> newsParams = new HashMap<String, String[]>();
		newsParams = request.getParameterMap();
		NewsDto ndto = new NewsDto();
		NewsService ns = new NewsService();
		Set<String> keys = newsParams.keySet();

		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			String key = it.next();
			String value = newsParams.get(key)[0];

			switch (key) {
			case "category": ndto.setCate(value);
				break;
			case "title": ndto.setTitle(value);
				break;
			case "author": ndto.setAuthor(value);
				break;
			case "newsLink": ndto.setNewsLink(value);
				break;
			case "contents": ndto.setCont(value);
				break;
			}
		}
		
		ns.insert(ndto);
	}

}
