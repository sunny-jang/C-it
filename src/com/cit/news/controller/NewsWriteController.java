package com.cit.news.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		String content = newsParams.get("contents")[0];
		
		
		String id = (String) request.getSession().getAttribute("id");
		ndto.setId(id);
		List<FileDto> fList = ExtractFiles.makeFileList(content);
		ns.insert(ndto, fList);
		
	
		response.sendRedirect(request.getContextPath()+"/NewsListController.do");
	}
	
	

}
