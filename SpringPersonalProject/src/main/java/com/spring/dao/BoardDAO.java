package com.spring.dao;

import java.util.List;

import com.spring.vo.BoardVO;
import com.spring.vo.PageCriteria;

public interface BoardDAO {
	public void insert(BoardVO boardVO) throws Exception;
	
	public BoardVO read(Integer boardId) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
	
	public void delete(Integer boardId) throws Exception;
	
	public List<BoardVO> list() throws Exception;
	
	public List<BoardVO> listPage(int page) throws Exception;
	
	public List<BoardVO> listCriteria(PageCriteria pageCriteria) throws Exception;
	
	public int countData(PageCriteria pageCriteria) throws Exception;
}
