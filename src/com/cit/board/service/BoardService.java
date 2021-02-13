package com.cit.board.service;

import java.sql.Date;
import java.util.ArrayList;

import com.cit.board.model.BoardDao;
import com.cit.board.model.BoardDto;

public class BoardService {
	
	BoardDao bdao = BoardDao.getInstance();
	BoardDto bdto = new BoardDto();
	
	public ArrayList<BoardDto> List () {
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>) bdao.getList();
		return list;
		
	}
}
