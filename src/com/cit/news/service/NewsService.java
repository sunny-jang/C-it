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
		FileDao fdao = FileDao.getInstance();
		
		int newsRs = ndao.insertNews(ndto, fList);
		if( newsRs ==1) {
			System.out.println("뉴스 정상 삽입");
			return 1;
		}else {
			System.out.println("뉴스 오류");
			return 0;
		}
		
	};
}
