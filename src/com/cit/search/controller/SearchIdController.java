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

@WebServlet("/searchId")
public class SearchIdController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAciont(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAciont(request,response);
	}

	protected void doAciont(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberDao mdao = MemberDao.getInstance();
		//request.setAttribute("mdto", mdto);
		MemberDto mdto = mdao.searchId(name, email);
		
		
		if(mdto != null) {
			request.setAttribute("mdto", mdto);
			RequestDispatcher rd = request.getRequestDispatcher("findIdSuccess.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("findId");
		}
	}
}
