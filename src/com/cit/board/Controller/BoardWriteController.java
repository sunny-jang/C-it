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
import javax.swing.JOptionPane;

import com.cit.board.model.BoardDto;
import com.cit.board.service.BoardService;
import com.cit.file.model.FileDto;
import com.cit.news.model.NewsDto;
import com.cit.news.service.NewsService;

@WebServlet("/BoardWrite.do")
public class BoardWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String id_ = (String)session.getAttribute("id");
		if( id_ == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인시 작성가능합니다.')");
			out.println("location.href='login/login.jsp'");
			out.println("</script>");
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardWrite.jsp");
			rd.forward(request, response);
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> boardParams = new HashMap<String, String[]>();
		boardParams = request.getParameterMap();
		BoardDto bdto = new BoardDto();
		BoardService bs = new BoardService();
		Set<String> keys = boardParams.keySet();

		Iterator<String> it = keys.iterator();

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
			}
		}
		
		String content = boardParams.get("contents")[0];
		
		String id = (String) request.getSession().getAttribute("id");
		bdto.setId(id);
		
		List<FileDto> fList = ExtractFiles.makeFileList(content);	// 정규식으로 이미지 태그 추출해서 파일 리스트 만듦
		bs.insert(bdto, fList);
		
	
		response.sendRedirect(request.getContextPath()+"/BoardList.do");
	}
	
}
