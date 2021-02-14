package com.cit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.member.model.MemberDto;
import com.cit.member.service.MemberService;

/**
 * Servlet implementation class MemberDelController
 */
@WebServlet("/MemberDelController.do")
public class MemberDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService ms = new MemberService();
		String id = request.getParameter("u_id");
		System.out.println(id);
		ms.delete(id);
	}

}
