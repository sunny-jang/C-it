package com.cit.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cit.board.model.BoardDto;
import com.cit.notice.model.NoticeDao;


@WebServlet("/notice")
public class NoticeContorller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao ndao = NoticeDao.getInstance();
		List<BoardDto> list = ndao.noticeList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/notice/notice_list_admin.jsp").forward(request, response);
	}
}
