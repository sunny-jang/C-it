package com.javateam.project.member.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;

import com.javateam.project.entity.MemberDto;
import com.javateam.project.member.dao.MemberDao;

public class MemberService {
	
	MemberDao mDao = MemberDao.getInstance();
	MemberDto mDto = new MemberDto();
	
	
	public boolean join(MemberDto mt) {

//		SimpleDateFormat df = new SimpleDateFormat("yyyymmdd");	// 반환하고자 하는 날짜 형태 지정
//		java.util.Date date = df.parse(birth_);	// parse메소드를 사용해서 Date 인스턴스를 생성
//		java.sql.Date birth = new Date(date.getTime());
		
		
		boolean result = mDao.insert(mt) ==1 ? true : false;

		return result;
	}



}
