package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insert(BoardVO boardVO) throws Exception{
		sqlSession.insert("insert", boardVO);
	}

	@Override
	public BoardVO read(Integer boardId) throws Exception {
		return sqlSession.selectOne("read", boardId);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		sqlSession.update("update", boardVO);
	}

	@Override
	public void delete(Integer boardId) throws Exception {
		sqlSession.delete("delete", boardId);
	}

	@Override
	public List<BoardVO> list() throws Exception {
		return sqlSession.selectList("list");
	}

}
