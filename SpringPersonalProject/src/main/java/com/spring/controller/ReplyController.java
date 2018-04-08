package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.ReplyService;
import com.spring.vo.PageCriteria;
import com.spring.vo.PagingMaker;
import com.spring.vo.ReplyVO;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Inject
	private ReplyService replyService;
	
	//write
	//@RequestBody : 전송된 데이터를(JSON같은)객체로 변환 시켜주는 어노테이션(ModelAttributes어노테이션과 유사,JSON은 사용안함.)
	//ResponseEntity:개발자가 직접 결과 데이터 + HTTP의 상태 코드를 직접 제어할 수 있는 클래스
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> input(@RequestBody ReplyVO replyVO){
		ResponseEntity<String> responseEntity = null;
		try {
			replyService.inputReply(replyVO);
			responseEntity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//댓글 리스트 가져오기
	@RequestMapping(value="/selectAll/{boardId}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("boardId") Integer boardId){
		
		ResponseEntity<List<ReplyVO>> responseEntity = null;
		
		try {
			responseEntity = new ResponseEntity<List<ReplyVO>>(replyService.replyList(boardId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//댓글 수정
	@RequestMapping(value="/{replyId}", method={RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> modify(
			@PathVariable Integer replyId, 
			@RequestBody ReplyVO replyVO) {
		
		ResponseEntity<String> responseEntity = null;
		
		try {
			replyVO.setReplyId(replyId);
			replyService.modifyReply(replyVO);
			
			responseEntity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//댓글 삭제
	@RequestMapping(value="/{replyId}", method=RequestMethod.DELETE)
	public ResponseEntity<String> replyDelete(@PathVariable Integer replyId){
		
		ResponseEntity<String> responseEntity = null;
		
		try {
			replyService.deleteReply(replyId);
			responseEntity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	//댓글 paging 처리
	@RequestMapping(value="/{boardId}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> replyListPage(
			@PathVariable("boardId") Integer boardId,
			@PathVariable("page") Integer page){
		
		ResponseEntity<Map<String, Object>> responseEntity = null;
		
		PageCriteria pageCriteria = new PageCriteria();
		pageCriteria.setPage(page);
		
		PagingMaker pagingMaker = new PagingMaker();
		pagingMaker.setPageCriteria(pageCriteria);
		
		try {
			Map<String, Object> replyMap = new HashMap<String, Object>();
			List<ReplyVO> replyListPage = replyService.replyListPage(boardId, pageCriteria);
			
			int replyCount = replyService.replyCount(boardId);
			pagingMaker.setTotalData(replyCount);
			
			replyMap.put("replyListPage", replyListPage);
			replyMap.put("pagingMaker", pagingMaker);
			
			responseEntity = new ResponseEntity<Map<String,Object>>(replyMap, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
}
