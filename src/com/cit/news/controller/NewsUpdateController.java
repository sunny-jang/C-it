package com.cit.news.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.Controller.ExtractFiles;
import com.cit.file.model.FileDto;
import com.cit.news.model.NewsDto;
import com.cit.news.service.NewsService;

/**
 * Servlet implementation class NewsUpdateController
 */
@WebServlet("/NewsUpdateController.do")
public class NewsUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		NewsService ns = new NewsService();
		NewsDto ndto = ns.getNews(num);
		
		request.setAttribute("post", ndto);
		request.setAttribute("update", true);
		RequestDispatcher rd = request.getRequestDispatcher("/news/news_write.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService ns = new NewsService();
		
		Map<String, String[]> newsParams = new HashMap<String, String[]>();
		newsParams = request.getParameterMap();
		NewsDto ndto = new NewsDto();
		Set<String> keys = newsParams.keySet();

		Iterator<String> it = keys.iterator();
		
		//TODO class reflection으로 바꾸기
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
			case "num": ndto.setNum(Integer.parseInt(value));
			break;
			}
		}
		
		List<FileDto> fList = ExtractFiles.makeFileList(ndto.getCont());
		ns.updateNews(ndto, fList);
		response.sendRedirect(request.getContextPath()+"/NewsListController.do");
	}

}
