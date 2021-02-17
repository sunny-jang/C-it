package com.cit.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessionOut(request, response);
	}
	
	public static void sessionOut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/MainViewController.do"); 
	}
}
