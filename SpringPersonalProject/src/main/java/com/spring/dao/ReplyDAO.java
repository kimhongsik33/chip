package com.spring.dao;

import java.util.List;

import com.spring.vo.PageCriteria;
import com.spring.vo.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> replyList(Integer boardId) throws Exception;
	
	public void write(ReplyVO replyVO) throws Exception;
	
	public void modify(ReplyVO replyVO) throws Exception;
	
	public void replyDelete(Integer replyId) throws Exception;
	
	//reply paging
	public List<ReplyVO> replyListPage(Integer boardId, PageCriteria pageCriteria) throws Exception;
	
	//reply Count
	public int replyCount(Integer boardId) throws Exception;
 }
