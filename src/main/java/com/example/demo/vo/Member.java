package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private String usrid; // 아이디(usrid) 
	private String usrpw; // 비번(usrpw), 
	private String name; // 이름(name), 
	private String nick; // 닉네임(nick), 
	private String phonNum; // 닉네임(nick), 
	private String email; // 이메일(email)
}
