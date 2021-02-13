package com.cit.news.service;

import java.util.ArrayList;
import java.util.Date;

import com.cit.board.model.BoardDto;
import com.cit.news.model.NewsDao;

public class NewsService {
	NewsDao ndao = NewsDao.getInstance();

	public NewsService(int num, String title, Date date, int views, String cont, String id, String cate, int rNum,
			String author, String newsLink) {
	}

	public ArrayList<BoardDto> newslist(int num, String title, Date date, int views, String cont, String id, String cate, int rNum,
			String author, String newsLink){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		list = ndao.newslist(num, title, date, views, cont, id, cate, rNum, author, newsLink);
		return list;
	}
}
