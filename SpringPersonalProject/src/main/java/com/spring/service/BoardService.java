package com.spring.service;

import java.util.List;

import com.spring.vo.BoardVO;

public interface BoardService {
	//データ作成
	public void write(BoardVO boardVO) throws Exception;
	
	//データ取得
	public BoardVO read(Integer boardId) throws Exception;
	
	//データ修正
	public void modify(BoardVO boardVO) throws Exception;
	
	//データ削除
	public void remove(Integer boardId) throws Exception;
	
	//データリストを取得
	public List<BoardVO> list() throws Exception;
}
