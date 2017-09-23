package com.kwan.dao;

import com.kwan.domain.MemberVO;

public interface MemberDAO {
	
	public String getTime();
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String userId) throws Exception;
	public MemberVO readWithPW(String userId, String userPw) throws Exception;

}
