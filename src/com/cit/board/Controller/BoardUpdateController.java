package com.cit.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.cit.board.model.BoardDto;
import com.cit.board.service.BoardDetailService;
import com.cit.board.service.BoardService;
import com.cit.file.model.FileDto;
import com.cit.news.model.NewsDto;
import com.cit.news.service.NewsService;

@WebServlet("/BoardUpdate.do")
public class BoardUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		BoardService bs = new BoardService();
		BoardDto bdto = bs.getPost(num);
		System.out.println(bdto.toString());
		request.setAttribute("post", bdto);
		request.setAttribute("update", true);
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardWrite.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService bs = new BoardService();
		
		Map<String, String[]> boardParams = new HashMap<String, String[]>();
		boardParams = request.getParameterMap();
		BoardDto bdto = new BoardDto();
		Set<String> keys = boardParams.keySet();

		Iterator<String> it = keys.iterator();
		
		//TODO class reflection으로 바꾸기
		while (it.hasNext()) {
			String key = it.next();
			String value = boardParams.get(key)[0];

			switch (key) {
			case "category": bdto.setCate(value);
				break;
			case "title": bdto.setTitle(value);
				break;
			case "contents": bdto.setCont(value);
				break;
			case "num": bdto.setNum(Integer.parseInt(value));
			break;
			}
		}
		
		List<FileDto> fList = ExtractFiles.makeFileList(bdto.getCont());
		bs.updateBoard(bdto, fList);
		response.sendRedirect(request.getContextPath()+"/BoardList.do");
	}

}
