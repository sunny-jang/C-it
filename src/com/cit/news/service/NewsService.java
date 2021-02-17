package com.cit.news.service;

import java.util.ArrayList;
import java.util.List;

import com.cit.file.model.FileDao;
import com.cit.file.model.FileDto;
import com.cit.news.model.NewsDao;
import com.cit.news.model.NewsDto;

public class NewsService {
	public ArrayList<NewsDto> getList() {
		NewsDao ndao = NewsDao.getInstance();
		return ndao.getNewsList();
		
	}

	public int insert(NewsDto ndto, List<FileDto> fList) {
		NewsDao ndao = NewsDao.getInstance();
		
		int newsRs = ndao.insertNews(ndto, fList);
		if( newsRs ==1) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	public NewsDto getNews(int num) {
		NewsDao ndao = NewsDao.getInstance();
		return ndao.getNews(num);
	}
	
	public int updateNews(NewsDto ndto, List<FileDto> fList) {
		NewsDao ndao = NewsDao.getInstance();
		ndao.updateNews(ndto, fList);
		return 0;
		
	}
}
