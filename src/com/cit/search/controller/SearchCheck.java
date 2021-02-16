package com.cit.search.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cit.member.model.MemberDao;

@WebServlet("/searchCheck.do")
public class SearchCheck extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao mdao = MemberDao.getInstance();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		JSONObject json = new JSONObject();
		
		if(name.equals("") || email.equals("")) {
			json.put("name", "-1");
			json.put("email", "-1");
		}
		response.getWriter().append(json.toJSONString());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
