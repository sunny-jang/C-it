package com.cit.board.service;

import java.util.List;

import com.cit.board.model.BoardDao;
import com.cit.board.model.BoardDto;
import com.cit.file.model.FileDto;
import com.cit.news.model.NewsDao;
import com.cit.news.model.NewsDto;

public class BoardService {

	public int insert(BoardDto bdto, List<FileDto> fList) {
		BoardDao bdao = BoardDao.getInstance();
		
		int boardRs = bdao.insertPost(bdto, fList);
		if( boardRs ==1) {
			return 1;
		}else {
			return 0;
		}
	}

	public BoardDto getPost(int num) {
		BoardDao bdao = BoardDao.getInstance();
		return bdao.getPost(num);
	}

	public int updateBoard(BoardDto bdto, List<FileDto> fList) {
		BoardDao bdao = BoardDao.getInstance();
		bdao.updatePost(bdto, fList);
		return 0;	
	}
}
