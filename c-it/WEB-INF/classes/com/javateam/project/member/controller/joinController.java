package com.javateam.project.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javateam.project.entity.MemberDto;
import com.javateam.project.member.dao.MemberDao;
import com.javateam.project.member.service.MemberService;

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
//		String path = request.getParameter("path");
		
//		String textJob = new String();
//		for(int i =0; i<job.length; i++) {
//			textJob += job[i]+" ";
//			System.out.println(textJob);
//		}
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
		java.sql.Date birth = new Date(date.getTime());
	
		//String birth_ = request.getParameter("year")+request.getParameter("month")+request.getParameter("day");
		MemberDto mDto = new MemberDto(id,pw,name,email,gender,birth,job,textPath);
		boolean result =  new MemberService().join(mDto);
		
		if(result) {
			System.out.println("성공");
			// 데이터 필요하기 때문에 dispatcher 사용
			RequestDispatcher dispatcher = request.getRequestDispatcher("/signUpResult.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("실패");
			// 데이터 필요없기 때문에 sendRedirect 사용
			response.sendRedirect("/join.jsp");
		}
	}
}
