package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Member;

@Mapper
public interface MemberDao {
	
	@Insert("""
			INSERT INTO `member`
				SET regDate = NOW()
					, updateDate = NOW()
					, loginId = #{usrId}
					, `loginPw` = #{usrPw}
					, name = #{name}
					, `nickname` = #{nick}
					, cellphoneNum = #{phonNum}
					, email = #{email}
					
			""")

	public Object doJoin(String usrId, String usrPw, String name, String nick, String phonNum, String email);
	
	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();
	@Select("""
			SELECT * 
				FROM `member`
				WHERE id = #{id}
			""")
	public Member getMemberById(int id);
	
	@Select("""
			SELECT COUNT(*)
			FROM `member`
			WHERE loginId = #{usrId}
			""")
	public Object checkById(String usrId, String usrPw, String name, String nick, String phonNum, String email);
}
