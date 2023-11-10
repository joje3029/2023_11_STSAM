package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MemberService;

@Controller
public class UsrMemberController {
	
	private MemberService memberService;
	
	UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String usrId, String usrPw, String name, String nick, String phonNum, String email) {
		
		Object joinResult=memberService.doJoin(usrId, usrPw, name, nick, phonNum, email);
		
//		return joinResult;
		if(joinResult==null) {
			return usrId+"는 이미 있는 아이디입니다. 가입 불가에요";
		} //왜 죽은거지?
		
		int id = memberService.getLastInsertId();
		
		return memberService.getMemberById(id);
	}
	
	
}
