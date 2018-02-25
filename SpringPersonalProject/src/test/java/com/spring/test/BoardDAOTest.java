package com.spring.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.BoardDAO;
import com.spring.vo.BoardVO;


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
	
	/*@Test
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
	
	@Test
	public void listTest() throws Exception{
		logger.info(boardDAO.list().toString());
	}
}
