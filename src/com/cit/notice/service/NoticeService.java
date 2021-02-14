package com.cit.notice.service;

import java.util.List;

import com.cit.board.model.BoardDto;
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
}
