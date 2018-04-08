package com.spring.service;

import java.util.List;

import com.spring.vo.PageCriteria;
import com.spring.vo.ReplyVO;

public interface ReplyService {
	public void inputReply(ReplyVO replyVO) throws Exception;
	
	//get reply list
	public List<ReplyVO> replyList(Integer boardId) throws Exception;
	
	//reply modify
	public void modifyReply(ReplyVO replyVO) throws Exception;
	
	//reply delete
	public void deleteReply(Integer replyId) throws Exception;
	
	//reply paging
	public List<ReplyVO> replyListPage(Integer boardId, PageCriteria pageCriteria) throws Exception;
	
	//reply Count
	public int replyCount(Integer boardId) throws Exception;
	
}
