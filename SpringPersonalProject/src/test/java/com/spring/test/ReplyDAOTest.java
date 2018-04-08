package com.spring.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.ReplyDAO;
import com.spring.vo.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//【@RunWith】
//Junit은 각각의 테스트가 서로 영향을 주지 않고 독립적으로 실행됨을 원칙으로 하기에 @Test 마다 오브젝트를 생성한다.
//이와 같은 Junit의 특성으로 인하여 ApplicationContext도 매번 새로 생성되기 때문에 테스트가 느려지는 단점이 있다.
//그러나 @RunWith 애노테이션은 각각의 테스트 별로 오브젝트가 생성 되더라도 싱글톤의 ApplicationContext를 보장한다
//【@ContextConfiguration】
//:spring bean 메타 설정 파일의 위치를 지정할 때 사용되는 애노테이션이며 경로를 지정하지 않으면
// 테스트 클래스 파일이 있는 패키지 내에서 [ContextConfigLocationTest-context.xml] 설정 파일을 사용한다.
public class ReplyDAOTest {
	
	@Inject
	private ReplyDAO replyDAO;
	
	private static Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Test
	public void wirteTest() throws Exception{
		ReplyVO replyVO = new ReplyVO();
		replyVO.setReplyContent("reply test with ARC");
		replyVO.setReplyer("Mr.Kim");
		replyVO.setBoardId(49135);
		
		replyDAO.write(replyVO);
	}
}
