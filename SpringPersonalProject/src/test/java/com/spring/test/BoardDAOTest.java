package com.spring.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.dao.BoardDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO boardDAO;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	/*@Test
	public void insertTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setSubject("テストタイトル");
		boardVO.setContent("テスト内容");
		boardVO.setWriter("KIM");
		boardDAO.insert(boardVO);
	}*/
	/*
	@Test
	public void readTest() throws Exception{
		logger.info(boardDAO.read(1).toString());
	}*/
	
	/*@Test
	public void updateTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(2);
		boardVO.setSubject("修正テスト");
		boardVO.setContent("修正内容");
		boardDAO.update(boardVO);
	}*/
	
	/*@Test
	public void deleteTesst() throws Exception{
		boardDAO.delete(3);
	}*/
	
	/*
	@Test
	public void listTest() throws Exception{
		logger.info(boardDAO.list().toString());
	}
	*/
	
	
	/*@Test
	public void listPageTest() throws Exception{
		int page = 5;
		List<BoardVO> list = boardDAO.listPage(page);
		
		for(BoardVO boardVO : list){
			logger.info(boardVO.getBoardId() + ":" + boardVO.getSubject());
		}
	}*/
	
	/*@Test
	public void listCriteriaTest() throws Exception{
		PageCriteria pageCriteria = new PageCriteria();
		pageCriteria.setPage(3);
		pageCriteria.setNumPerPage(15);
		
		List<BoardVO> list = boardDAO.listCriteria(pageCriteria);
		for(BoardVO boardVO : list){
			logger.info(boardVO.getBoardId() + ":" + boardVO.getSubject());
		}
	}*/
	
	/*//UriComponentBuilder를 이용하는 법 : org.springframework.web.util 패키지에 있음
	@Test
	public void uriTest() throws Exception{
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("boardId", 100)
				.queryParam("numPerPage", 20)
				.build();
		
		logger.info("/board/read/boardId=100&numPerPage=20");
		logger.info(uriComponents.toString());
	}*/
	
	@Test
	public void uriTest2() throws Exception{
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("boardId", 100)
				.queryParam("numPerPage", 20)
				.build()
				.expand("board","read")   //{module}:board, {page}:read
				.encode();
		
		logger.info("/board/read?boardId=100&numPerPage=20");
		logger.info(uriComponents.toString());
	}
}