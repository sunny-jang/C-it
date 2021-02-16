package com.cit.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.model.BoardDto;
import com.cit.notice.service.NoticeService;


@WebServlet("/noticeListAdmin.do")
public class NoticeListContorller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int admin = Integer.parseInt(request.getParameter("admin"));
		List<BoardDto> list = new NoticeService().noticeList();
		request.setAttribute("list", list);
         
		if(list != null) {
			request.getRequestDispatcher("/notice/noticeListAdmin.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "등록된 글이 없습니다.");
			request.getRequestDispatcher("/notice/noticeListAdmin.jsp").forward(request, response);
		}
	}
	
	public void setPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String endNum = null;
		if(request.getParameter("pageEnd") != null) {
			endNum = request.getParameter("pageEnd");
			request.setAttribute("endNum", Integer.parseInt(endNum));
		}else {
			request.setAttribute("endNum", 4);
		}
	}
}
