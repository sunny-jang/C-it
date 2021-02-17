package com.cit.notice.service;

import java.util.List;

import com.cit.board.model.BoardDto;
import com.cit.news.model.NewsDao;
import com.cit.news.model.NewsDto;
import com.cit.notice.model.NoticeDao;

public class NoticeService {
	NoticeDao ndao = NoticeDao.getInstance();
	
	public List<BoardDto> noticeList() {
		List<BoardDto> bdto = ndao.noticeList();
		return bdto;
	}
	
	public int noticeDel(int num) {
		int result = ndao.noticeDel(num);
		return result; 
	}
	
	public int insertNotice(String title, String cont, String id) {
		int result = ndao.insertNotice(title, cont, id);
		return result;
	}
	
	public int updateNotice(String title, String cont, int num) {
		int result = ndao.updateNotice(title, cont, num);
		return result;
	}
	
	public BoardDto getNotice(int num) {
		BoardDto bdto = new BoardDto();
		bdto = ndao.getNotice(num);
		return bdto;
	}
}
