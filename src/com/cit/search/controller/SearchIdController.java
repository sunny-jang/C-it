package com.cit.search.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.member.model.MemberDao;
import com.cit.member.model.MemberDto;
import com.cit.search.service.SearchService;

@WebServlet("/searchId.do")
public class SearchIdController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		SearchService ss = new SearchService();
		MemberDto mdto = ss.seachId(name, email);
		
		if(mdto != null) {
			request.setAttribute("mdto", mdto);
			RequestDispatcher rd = request.getRequestDispatcher("/search/findIdSuccess.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "입력하신 정보와 일치하는 아이디가 없습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("/search/findIdFail.jsp");
			rd.forward(request, response);
		}
	}
}
