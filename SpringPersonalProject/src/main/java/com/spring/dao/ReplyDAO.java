package com.spring.dao;

import java.util.List;

import com.spring.vo.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> list(Integer boardId) throws Exception;
	
	public void write(ReplyVO replyVO) throws Exception;
	
	public void modify(ReplyVO replyVO) throws Exception;
	
	public void delete(Integer replyId) throws Exception;
 }
