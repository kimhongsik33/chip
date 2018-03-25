package com.spring.service;

import java.util.List;

import com.spring.vo.BoardVO;
import com.spring.vo.FindCriteria;
import com.spring.vo.PageCriteria;

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
	
	//1ページごとに何件のレコードを取得するか
	public List<BoardVO> listCriteria(PageCriteria pageCriteria) throws Exception;
	
	//データ総数を取得する
	public int countData(PageCriteria pageCriteria) throws Exception;
	
	
	public List<BoardVO> listFindCriteria(FindCriteria findCriteria) throws Exception;
	public int findCountData(FindCriteria findCriteria) throws Exception;
}
