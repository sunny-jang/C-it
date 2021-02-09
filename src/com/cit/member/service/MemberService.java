package com.cit.member.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;

import com.cit.member.model.MemberDao;
import com.cit.member.model.MemberDto;

public class MemberService {

	MemberDao mDao = MemberDao.getInstance();
	MemberDto mDto = new MemberDto();


	public boolean join(MemberDto mt) {


		boolean result = mDao.insert(mt) ==1 ? true : false;

		return result;
	}



}