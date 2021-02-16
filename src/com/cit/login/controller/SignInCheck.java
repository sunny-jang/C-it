package com.cit.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cit.login.service.loginService;
import com.cit.member.model.MemberDao;
import com.cit.member.model.MemberDto;

@WebServlet("/signInCheck.do")
public class SignInCheck extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao mdao = MemberDao.getInstance();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		JSONObject json = new JSONObject();
		int result = 0;
		
		if(id.equals("") || pw.equals("")) {
			json.put("id", "-1");
			json.put("pw", "-1");
		}else {
			//int result =  mdao.loginCheck(id, pw);
			loginService ls = new loginService();
			result = ls.loginCheck(id, pw);
			if(result == -1) {
				json.put("id", id);
				json.put("pw", pw);
				json.put("result", "-1"); // 비밀번호가 다를 경우	
			}else if(result == 0){
				json.put("result", "0");	// 아이디가 없을 경우
			}
		}
		response.getWriter().append(json.toJSONString());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
