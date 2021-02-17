package com.cit.member.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.member.model.MemberDao;
import com.cit.member.model.MemberDto;
import com.cit.member.service.MemberService;

@WebServlet("/MemberUpdateController.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = String.valueOf(request.getSession().getAttribute("id"));
		MemberDto mt = MemberDao.getInstance().getMember("id", id);
		String[] birth = splitBirthFormat(mt);
		
		request.setAttribute("member", mt);
		request.setAttribute("birth", birth);
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService ms = new MemberService();
		MemberDto mdto = new MemberDto();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String bd = request.getParameter("year")+request.getParameter("month")+request.getParameter("day");
		
		java.sql.Date birth = null;
		birth = checkBirthDate(bd);
		
		mdto.setId(id);
		mdto.setPw(pw);
		mdto.setName(name);
		mdto.setEmail(email);
		mdto.setBirth(birth);
		ms.update(mdto);
		System.out.println("업데이트 완료");
		RequestDispatcher rd = request.getRequestDispatcher("/MemberUpdateController.do");
		rd.forward(request, response);
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
	
	public String[] splitBirthFormat(MemberDto mdto) {
		String[] birth = {"","",""};
		if(mdto.getBirth() != null) {
			birth = String.valueOf(mdto.getBirth()).split("-");
		}
		return birth;
	}

}
