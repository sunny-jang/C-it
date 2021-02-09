package com.cit.member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.member.model.MemberDto;
import com.cit.member.service.MemberService;

@WebServlet("/joinController")
	public class joinController extends HttpServlet {

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");


			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String job = request.getParameter("job");
//			String path = request.getParameter("path");

//			String textJob = new String();
//			for(int i =0; i<job.length; i++) {
//				textJob += job[i]+" ";
//				System.out.println(textJob);
//			}
//			
//			
//			
			String[] path = request.getParameterValues("path");
			String textPath ="";
			for(int i =0; i<path.length; i++) {
				if(i==path.length-1) {
					textPath += path[i];
					break;
				}
				textPath+= path[i]+",";
			} 

			SimpleDateFormat df = new SimpleDateFormat("yyyymmdd");	
			java.util.Date date = null;
			try {
				date = df.parse(request.getParameter("year")+request.getParameter("month")+request.getParameter("day"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			java.sql.Date birth = new java.sql.Date(date.getTime());

			//String birth_ = request.getParameter("year")+request.getParameter("month")+request.getParameter("day");
			MemberDto mDto = new MemberDto(id,pw,name,email,gender,birth,job,textPath);
			boolean result =  new MemberService().join(mDto);

			if(result) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/member/signUpResult.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() +"/member/join.jsp");
			}
		}
	}

