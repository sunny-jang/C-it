package com.cit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cit.board.model.BoardDto;
import com.cit.member.service.MemberService;
import com.cit.member.service.MyPageMainService;

@WebServlet("/Mypage.do")
public class MyPageMainController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_ = request.getParameter("id");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
			dispatcher.forward(request, response);	
		}else if(id.equals(id_)) {
			MyPageMainService mms = new MyPageMainService();
			ArrayList<BoardDto> myList = mms.getMyList(id);
			request.setAttribute("myList", myList);
		}
	}
}
