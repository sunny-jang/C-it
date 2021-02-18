package com.cit.member.service;

import java.util.ArrayList;

import com.cit.board.model.BoardDao;
import com.cit.board.model.BoardDto;

public class MyPageMainService {
	public ArrayList<BoardDto> getMyList(String id){
		BoardDao bdao = BoardDao.getInstance();
		ArrayList<BoardDto> myList = bdao.getList();
		
		return myList;
	}
}
