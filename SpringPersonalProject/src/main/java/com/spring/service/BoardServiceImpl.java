package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.BoardDAO;
import com.spring.vo.BoardVO;
import com.spring.vo.PageCriteria;

@Service //Buisiness階層として認識するため「@Service」アノテーションを使用する。
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		boardDAO.insert(boardVO);
	}

	@Override
	public BoardVO read(Integer boardId) throws Exception {
		return boardDAO.read(boardId);
	}

	@Override
	public void modify(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}

	@Override
	public void remove(Integer boardId) throws Exception {
		boardDAO.delete(boardId);
	}

	@Override
	public List<BoardVO> list() throws Exception {
		return boardDAO.list();
	}

	@Override
	public List<BoardVO> listCriteria(PageCriteria pageCriteria) throws Exception {
		return boardDAO.listCriteria(pageCriteria);
	}
}
