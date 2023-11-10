package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.Member;

@Service
public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Object doJoin(String usrId, String usrPw, String name, String nick, String phonNum, String email){
		Object count=memberDao.checkById(usrId, usrPw, name, nick, phonNum, email);
		if(count==null) { //1이다 = 아이디가 있다. 즉 지금은 1이 아니다 가입 가능하다.
			return null;//가입 안될 때
		}
		return memberDao.doJoin(usrId, usrPw, name, nick, phonNum, email); //가입 가능 할때
		
	}
	public int getLastInsertId() {
		return memberDao.getLastInsertId();
	}

	public Member getMemberById(int id) {
		return memberDao.getMemberById(id);
	}
}
