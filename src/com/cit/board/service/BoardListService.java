package com.cit.board.service;

import java.sql.Date;
import java.util.ArrayList;

import com.cit.board.model.BoardDao;
import com.cit.board.model.BoardDto;

public class BoardListService {
	
	BoardDao bdao = BoardDao.getInstance();
	BoardDto bdto = new BoardDto();
	
	// boardList 보기
	public ArrayList<BoardDto> List () {
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>) bdao.getList();
		return list;		
	}
}
