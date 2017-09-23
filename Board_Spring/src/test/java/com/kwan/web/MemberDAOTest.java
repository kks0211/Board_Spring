package com.kwan.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwan.dao.MemberDAO;
import com.kwan.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime() throws Exception {
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testinsertMember() throws Exception { 
		MemberVO vo = new  MemberVO();
		vo.setUserId("zxc2");
		vo.setUserPw("zxc2");
		vo.setUserName("zxc2");
		vo.setUserEmail("zxc2@zxc.com");
		
		dao.insertMember(vo);
	}

}
