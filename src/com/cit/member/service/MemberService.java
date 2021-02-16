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
	
	public int delete(String id) {
		mDto = mDao.getMember("id", id);
		
		if(mDto != null) {
			mDao.deleteMember(mDto);
		}
		return 0;
	}

	public void update(MemberDto mdto) {
		String id = mdto.getId();
		int result = 0;
		
		if(mDao.getMember("id", id)!= null) {
			result = mDao.updateMember(mdto);
		}
	}
	
	public MemberDto get(String id) {
		mDto = mDao.getMember("id", id);
		return mDto;
	}
}