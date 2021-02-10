package com.cit.search.service;

import com.cit.member.model.MemberDao;
import com.cit.member.model.MemberDto;

public class SearchService {
	MemberDao mdao = MemberDao.getInstance();
	
	public MemberDto seachId(String name, String email) {
		MemberDto mdto = mdao.searchId(name, email);
		
		return mdto;
	}
	
	public MemberDto searchPw(String name, String id, String email) {
		MemberDto mdto = mdao.searchPw(name, id, email);
		
		return mdto;
	}
}
