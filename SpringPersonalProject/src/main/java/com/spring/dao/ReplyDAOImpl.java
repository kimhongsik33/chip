package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ReplyVO> list(Integer boardId) throws Exception {
		return sqlSession.selectList("list", boardId);
	}

	@Override
	public void write(ReplyVO replyVO) throws Exception {
		sqlSession.insert("write", replyVO);
	}

	@Override
	public void modify(ReplyVO replyVO) throws Exception {
		sqlSession.update("modify", replyVO);
	}

	@Override
	public void delete(Integer replyId) throws Exception {
		sqlSession.delete("delete", replyId);
	}
}
