package com.cit.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.model.BoardDto;
import com.cit.notice.service.NoticeService;

@WebServlet("/NoticUpdate.do")
public class NoticeUpController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		NoticeService ns = new NoticeService();
		BoardDto bdto = ns.getNotice(num);
		
		request.setAttribute("post", bdto);
		request.setAttribute("update", true);
		RequestDispatcher rd = request.getRequestDispatcher("/notice/noticeWrite.jsp");
		rd.forward(request, response);
	}
	

}
