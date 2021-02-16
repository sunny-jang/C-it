package com.cit.member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.member.model.MemberDto;
import com.cit.member.service.MemberService;

@WebServlet("/JoinController.do")
public class JoinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/join.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String textPath ="";
		java.sql.Date birth = null;
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String[]> aa = request.getParameterMap();
		
		System.out.println(aa.get("id"));
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] path = request.getParameterValues("path");
		String bd = request.getParameter("year")+request.getParameter("month")+request.getParameter("day");
		
		textPath = checkJoinPath(path);
		birth = checkBirthDate(bd);

		MemberDto mDto = new MemberDto(id,pw,name,email,gender,birth,job,textPath,0);
		boolean result =  new MemberService().join(mDto);

		if(result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() +"/login/login.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() +"/member/join.jsp");
		}
	}
	
	public String checkJoinPath(String[] path) {
		String textPath = "";
		if(path != null) {
			for(int i =0; i<path.length; i++) {
				if(i==path.length-1) {
					textPath += path[i];
					break;
				}
				textPath+= path[i]+",";
			} 
		}
		
		return textPath;
	}
	
	public java.sql.Date checkBirthDate(String bd) {
		java.sql.Date birth = null;
		if(!bd.equals("")) {
			SimpleDateFormat df = new SimpleDateFormat("yyyymmdd");	
			java.util.Date date = null;
			try {
				date = df.parse(bd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			birth = new java.sql.Date(date.getTime());
		}
		return birth;
	}
}

