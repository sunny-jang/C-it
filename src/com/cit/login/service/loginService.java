package com.cit.login.service;

import com.cit.member.model.MemberDao;
import com.cit.member.model.MemberDto;

public class loginService {
	
	MemberDao mDao = MemberDao.getInstance();
	MemberDto mDto = new MemberDto();
	
	public int loginCheck(String id,String pw) {
		
		MemberDto mdto = mDao.getMember("id",id);
		int result = 0;
		
		String pass = mdto.getPw();
		String id_ = mdto.getId();
		
		if(pass.equals(pw) && id_.equals(id)) {
			result = 1;	// 입력받은 아이디와 비번이 같으면 1
		}else if(!pass.equals(pw)){
			result = -1;	// 비번이 다를 경우 -1
		}else if(id_.equals(id)){
			result = 0;	// 아이디가 없을 경우
		}
		
		return result;
		
	}
}
