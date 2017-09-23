package com.kwan.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kwan.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.kwan.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember", vo);
	}
	
	@Override
	public MemberVO readMember(String userId) throws Exception { 
		return (MemberVO)sqlSession.selectOne(namespace+".readMember", userId);
	}
	
	@Override
	public MemberVO readWithPW(String userId, String userPw) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("userPw", userPw);
		
		return sqlSession.selectOne(namespace+".readWithPW", paramMap);
	}
	
}
