package com.cit.board.service;

import java.util.ArrayList;

import com.cit.board.model.BoardDao;
import com.cit.board.model.BoardDto;

public class BoardDetailService {

	BoardDao bdao = BoardDao.getInstance();
	BoardDto bdto = new BoardDto();
	
	public BoardDto getBoard(int num) {
		BoardDto BDetail = bdao.getBoardDetail(num);
	
		return BDetail;
	}
}
