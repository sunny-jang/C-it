package com.cit.news.service;

import java.util.ArrayList;

import com.cit.news.model.NewsDao;
import com.cit.news.model.NewsDto;

public class NewsService {
	public ArrayList<NewsDto> getList() {
		NewsDao ndao = NewsDao.getInstance();
		return ndao.getNewsList();
		
	}

	public int insert(NewsDto ndto) {
		NewsDao ndao = NewsDao.getInstance();
		return ndao.insertNews(ndto);
	};
}
