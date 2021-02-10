package com.cit.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cit.login.service.loginService;

@WebServlet("/loginController")
public class loginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		loginService ls = new loginService();
		int result = ls.loginCheck(id, pw);
	
		if(result == 1 ) {
			HttpSession session = request.getSession(true);
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp"); 
			System.out.println("로그인 성공");
			
		}else if(result == -1) {
			System.out.println("비밀번호가 다릅니다");
			response.sendRedirect("/login.jsp");
			
		}else {
			System.out.println("아이디가 없습니다.");
			response.sendRedirect("/login.jsp");
		}
	}
}
