package com.kwan.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.kwan.dao.BoardDAO;
import com.kwan.domain.BoardVO;
import com.kwan.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("new board");
		vo.setContent("new board");
		vo.setWriter("user00");
		dao.create(vo);
	}
	
	@Test
	public void testRead() throws Exception {
		log.info(dao.read(1).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(989);
		vo.setTitle("modify board");
		vo.setContent("modify text");
		dao.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(989);
	}
	
	@Test
	public void testListPage() throws Exception {
		int page=3;
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO : list){
			log.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	
	@Test
	public void testListCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO boardVO : list) {
			log.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	
	@Test
	public void testURI() throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/board/read").queryParam("bno", 12).queryParam("perPageNum", 20).build();
		
		log.info("/board/read?bno=12&perPageNum=20");
		log.info("=================================");
		log.info(uriComponents.toString());
	}

}
