package com.spring.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.service.BoardService;
import com.spring.vo.BoardVO;
import com.spring.vo.PageCriteria;
import com.spring.vo.PagingMaker;

@Controller
@RequestMapping("/board/*") //共通パス指定
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void writeGET(BoardVO boardVO, Model model) throws Exception{
		//Model : データ渡し用クラス, Key-Value
		logger.info("write GET");
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	//public String writePOST(BoardVO boardVO, Model model) throws Exception{
	//redirectAttributer객체는 리다이렉트 시점에 한번만 사용되는 데이터를 전송할 수 있는 addFlashAttribute() 메소드를 지원.
	public String writePOST(BoardVO boardVO, RedirectAttributes reAttr) throws Exception{
		logger.info("write POST");
		logger.info(boardVO.toString());
		
		boardService.write(boardVO);
		//model.addAttribute("result", "Complete Insert");
		reAttr.addFlashAttribute("result", "success");
		
		//return "board/resultOK";
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) throws Exception{
		logger.info("Get Content List");
		
		model.addAttribute("list", boardService.list());
	}
	
	//@RequestParam : Servlet에서 request.getParameter()과 유사한 기능이다.
	//servlet의 request는  HttpServletRequest
	//@RequestParam 과 HttpServletRequest의 차이점 : 문자열, 숫자 등의 형변환 여부 (@RequestParam은 가능, HttpServletRequest는 불가능) 
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void readPage(
			@RequestParam("boardId") int boardId,
			@ModelAttribute("pageCriteria") PageCriteria pageCriteria,
			Model model) throws Exception{
		
		//model.addAttribute에 아래와 같이 value값만 있을 경우 리턴되는 클래스가 키값이 된다. 그때 키는 클래스의 첫문자가 소문자로 설정된다.
		//예를 들어, 아래의 경우 [boardService.read(boardId)]의 리턴클래스는 BoardVO클래스이므로
		//Key 값은 boardVO가 된다.
		model.addAttribute(boardService.read(boardId));
	}
	
	/*@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("boardId") int boardId, RedirectAttributes reAttr) throws Exception{
		
		boardService.remove(boardId);
		reAttr.addFlashAttribute("result", "success");
		return "redirect:/board/list";
	}*/
	
	//RedirectAttributes은 : FlashMap 이라는 잠깐 동안 담을 수 있는 맵에 값을 담았다가 값을 보내준 후에는 증발해버리는 기능을 가진 Map
	@RequestMapping(value="/deletePage", method=RequestMethod.GET)
	public String deletePage(
			@RequestParam("boardId") int boardId,
			PageCriteria pageCriteria,
			RedirectAttributes reAttr) throws Exception{
		
		boardService.remove(boardId);
		
		reAttr.addAttribute("page", pageCriteria.getPage());
		reAttr.addAttribute("numPerPage", pageCriteria.getNumPerPage());
		reAttr.addFlashAttribute("result", "success");
		return "redirect:/board/pageList";
	}
	
	/*//modify inquiry
	@RequestMapping(value="/modifyPage",  method=RequestMethod.GET)
	public void modifyGET(int boardId, Model model) throws Exception{
		model.addAttribute(boardService.read(boardId));
	}*/
	
	//modify inquiry
	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyGET(
			@RequestParam("boardId") int boardId,
			@ModelAttribute("pageCriteria") PageCriteria pageCriteria,
			Model model) throws Exception{
		
		model.addAttribute(boardService.read(boardId));
	}
	
	/*//modify process
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPOST(BoardVO boardVO, RedirectAttributes reAttr) throws Exception{
		logger.info("Called modifyPOST()");
		
		boardService.modify(boardVO);
		reAttr.addFlashAttribute("result", "success");
		return "redirect:/board/list";
	}*/
	
	//modify process
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPOST(BoardVO boardVO, PageCriteria pageCriteria, RedirectAttributes reAttr) throws Exception{
		boardService.modify(boardVO);
		reAttr.addAttribute("page", pageCriteria.getPage());
		reAttr.addAttribute("numPerPage", pageCriteria.getNumPerPage());
		reAttr.addFlashAttribute("result", "success");
		
		return "redirect:/board/pageList";
	}
	
	@RequestMapping(value="/pageListTest", method=RequestMethod.GET)
	public void pageListTest(PageCriteria pageCriteria, Model model) throws Exception{
		logger.info(" call pageListTest()");
		
		model.addAttribute("list", boardService.listCriteria(pageCriteria));
	}
	
	@RequestMapping(value="/pageList", method=RequestMethod.GET)
	public void pageList(PageCriteria pageCriteria, Model model) throws Exception{
		logger.info(pageCriteria.toString());
		
		model.addAttribute("list", boardService.listCriteria(pageCriteria));
		PagingMaker pagingMaker = new PagingMaker();
		pagingMaker.setPageCriteria(pageCriteria);
		pagingMaker.setTotalData(boardService.countData(pageCriteria));
		
		model.addAttribute("pagingMaker", pagingMaker);
	}
}
