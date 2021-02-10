package com.cit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


@WebServlet("/checkAuth.do")
public class CheckAuthController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("??");
		JSONObject json = new JSONObject();
		String authNum = request.getParameter("authNum");
		
		HttpSession session = request.getSession();
		
		if(authNum.equals("") || authNum == null) {
			json.put("check", "값 없음");
		}else if(authNum.equals(session.getAttribute("authNum"))) {
			json.put("check", "일치");
		}else {
			json.put("check", "불일치");
		}
		
		response.getWriter().append(json.toJSONString());
	}
}
