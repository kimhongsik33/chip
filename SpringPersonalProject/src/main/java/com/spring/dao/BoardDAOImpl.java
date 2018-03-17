package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.BoardVO;
import com.spring.vo.PageCriteria;

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

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if(page <= 0){
			page = 1;
		}
		page = (page - 1) * 10;
		return sqlSession.selectList("listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(PageCriteria pageCriteria) throws Exception {
		return sqlSession.selectList("listCriteria", pageCriteria);
	}

	@Override
	public int countData(PageCriteria pageCriteria) throws Exception {
		return sqlSession.selectOne("countData", pageCriteria);
	}

}
