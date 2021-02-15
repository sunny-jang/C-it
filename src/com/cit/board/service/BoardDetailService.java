package com.cit.board.service;

import java.util.ArrayList;

import com.cit.board.model.BoardDao;
import com.cit.board.model.BoardDto;

public class BoardDetailService {

	BoardDao bdao = BoardDao.getInstance();
	BoardDto bdto = new BoardDto();
	
	public ArrayList<BoardDto> List(int num) {
		ArrayList<BoardDto> list = (ArrayList<BoardDto>) bdao.getBoardDetail(num);
		return list;
		
	}
}
