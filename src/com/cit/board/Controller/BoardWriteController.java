package com.cit.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/boardWrite.do")
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
			response.sendRedirect("/board/boardWrite.jsp");
		}
		
	}
}
