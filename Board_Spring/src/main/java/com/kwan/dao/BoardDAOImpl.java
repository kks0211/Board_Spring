package com.kwan.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kwan.domain.BoardVO;
import com.kwan.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.kwan.mapper.BoardMapper";

	@Override
	public void create(BoardVO board) throws Exception {
		session.insert(namespace + ".create", board);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		session.update(namespace + ".update", board);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}
	
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;

		return session.selectList(namespace + ".listPage", page);
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
		
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace+".countPaging", cri);
	}
}
