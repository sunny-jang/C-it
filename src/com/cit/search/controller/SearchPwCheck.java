package com.cit.search.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cit.member.model.MemberDao;

@WebServlet("/searchPwCheck.do")
public class SearchPwCheck extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao mdao = MemberDao.getInstance();
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		JSONObject json = new JSONObject();
		
		if(name.equals("") && id.equals("") && email.equals("")) {
			json.put("name", "1");
		}else if(name.equals("") && id.equals("")) {
			json.put("name", "0");
		}else if(id.equals("") && email.equals("")) {
			json.put("id", "0");
		}else if(name.equals("") && email.equals("")) {
			json.put("email", "0");
		}else if(name.equals("")) {
			json.put("name", "-1");
		}else if(id.equals("")) {
			json.put("id", "-1");
		}else if(email.equals("")) {
			json.put("email", "-1");
		}
		
		response.getWriter().append(json.toJSONString());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
