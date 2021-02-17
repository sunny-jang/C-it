package com.cit.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cit.board.model.BoardDto;
import com.cit.member.model.MemberDto;
import com.cit.notice.model.NoticeDao;
import com.cit.notice.service.NoticeService;

@WebServlet("/NoticeWrite.do")
public class NoticeWriteController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String cont = request.getParameter("contents");
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("id");
		
	
		int result = new NoticeService().insertNotice(title,cont,sessionID);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("/NoticeListAdmin.do").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request,response);
	}

}
