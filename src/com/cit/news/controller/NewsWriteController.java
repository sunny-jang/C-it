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

import com.cit.file.model.FileDto;
import com.cit.news.model.NewsDto;
import com.cit.news.service.NewsService;

import oracle.net.aso.i;

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
		System.out.println("path : "+ request.getAttribute("path"));
		ndto.setId(id);
		List<String> imagePath = extractImageSrc(content, "<img[^>]*src=[\\\"']?([^>\\\"']+)[\\\"']?[^>]*>");
		List<String> imageName = extracImageName(imagePath);
		List<FileDto> fList = new ArrayList<FileDto>();
		
		for(int i =0; i<imagePath.size(); i++) {
			FileDto fdto = new FileDto();
			fdto.setPath(imagePath.get(i));
			fdto.setcName(imageName.get(i));
			
			fList.add(fdto);
		}
		
		System.out.println(fList.toString());
		
		ns.insert(ndto, fList);
		
	
		response.sendRedirect(request.getContextPath()+"/NewsListController.do");
	}
	
	public List<String> extractImageSrc(String content, String reg) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(content);
		List<String> imagePath = new ArrayList<String>();
		
		
		while(matcher.find()) {
			imagePath.add(matcher.group(1).trim());
		};
		return imagePath;
		
	}
	
	public List<String> extracImageName(List<String> imagePath) {
		List<String> imageName = new ArrayList<String>();
		
		for(String image : imagePath) {
			int lastIndex = image.lastIndexOf("/");
			String result = image.substring(lastIndex+1);
			imageName.add(result);
		}
		return imageName;
	}

}
