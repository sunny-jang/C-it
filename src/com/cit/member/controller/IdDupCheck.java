package com.cit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.cit.member.model.MemberDao;
import com.cit.member.model.MemberDto;

@WebServlet("/IdDupCheck.do")
public class IdDupCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		String id = request.getParameter("id");
		JSONObject json = new JSONObject();
		
		if(id.equals("")) {
			json.put("id", "-1");
		}else {
			MemberDto mdto = mdao.getMember(id);
			if(mdto == null) {
				json.put("id","1");
			}else {
				json.put("id", "0");
			}
		}
		
		response.getWriter().append(json.toJSONString());
	}
}
