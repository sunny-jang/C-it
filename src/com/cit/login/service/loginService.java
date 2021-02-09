package com.cit.login.service;

import com.cit.member.model.MemberDao;
import com.cit.member.model.MemberDto;

public class loginService {
	
	MemberDao mDao = MemberDao.getInstance();
	MemberDto mDto = new MemberDto();
	
	public int loginCheck(String id, String pw) {
		System.out.println("4");
		int result = mDao.loginCheck(id, pw);
		return result;
	}
}
