package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.PageCriteria;
import com.spring.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ReplyVO> replyList(Integer boardId) throws Exception {
		return sqlSession.selectList("replyList", boardId);
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
	public void replyDelete(Integer replyId) throws Exception {
		sqlSession.delete("replyDelete", replyId);
	}

	@Override
	public List<ReplyVO> replyListPage(Integer boardId, PageCriteria pageCriteria) throws Exception {
		Map<String, Object> replyMap = new HashMap<>();
		replyMap.put("boardId", boardId);
		replyMap.put("pageCriteria", pageCriteria);
		
		return sqlSession.selectList("replyListPage", replyMap);
	}

	@Override
	public int replyCount(Integer boardId) throws Exception {
		
		return sqlSession.selectOne("replyCount", boardId);
	}
}
