package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ReplyDAO;
import com.spring.vo.PageCriteria;
import com.spring.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	private ReplyDAO replyDAO;

	@Override
	public void inputReply(ReplyVO replyVO) throws Exception {
		replyDAO.write(replyVO);
	}

	@Override
	public List<ReplyVO> replyList(Integer boardId) throws Exception {
		return replyDAO.replyList(boardId);
	}

	@Override
	public void modifyReply(ReplyVO replyVO) throws Exception {
		replyDAO.modify(replyVO);
	}

	@Override
	public void deleteReply(Integer replyId) throws Exception {
		replyDAO.replyDelete(replyId);
	}

	@Override
	public List<ReplyVO> replyListPage(Integer boardId, PageCriteria pageCriteria) throws Exception {
		return replyDAO.replyListPage(boardId, pageCriteria);
	}

	@Override
	public int replyCount(Integer boardId) throws Exception {
		return replyDAO.replyCount(boardId);
	}
}
