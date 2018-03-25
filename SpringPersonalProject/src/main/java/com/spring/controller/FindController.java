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
import com.spring.vo.FindCriteria;
import com.spring.vo.PagingMaker;

@Controller
@RequestMapping("/findBoard/*")
public class FindController {
	
	private static final Logger logger = LoggerFactory.getLogger(FindController.class);
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(@ModelAttribute("findCriteria") FindCriteria findCriteria, Model model) throws Exception{
		logger.info(findCriteria.toString());
		
		//model.addAttribute("list", boardService.listCriteria(findCriteria));
		model.addAttribute("list", boardService.listFindCriteria(findCriteria));
		PagingMaker pagingMaker = new PagingMaker();
		pagingMaker.setPageCriteria(findCriteria);
		
		//pagingMaker.setTotalData(boardService.countData(findCriteria));
		pagingMaker.setTotalData(boardService.findCountData(findCriteria));
		
		model.addAttribute("pagingMaker", pagingMaker);
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void readPage(
			@RequestParam("boardId") int boardId,
			@ModelAttribute("findCriteria") FindCriteria findCriteria,
			Model model) throws Exception{
		
			model.addAttribute(boardService.read(boardId));
	}
	
	@RequestMapping(value="/deletePage", method=RequestMethod.POST)
	public String deletePage(
			@RequestParam("boardId") int boardId,
			FindCriteria findCriteria,
			RedirectAttributes reAttr) throws Exception{
			
			boardService.remove(boardId);
			reAttr.addAttribute("page", findCriteria.getPage());
			reAttr.addAttribute("numPerPage", findCriteria.getNumPerPage());
			reAttr.addAttribute("findType", findCriteria.getFindType());
			reAttr.addAttribute("keyWord", findCriteria.getKeyWord());
			
			reAttr.addFlashAttribute("result", "success");
			
			return "redirect:/findBoard/list";
	}
	
	//修正照会ページ
	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyGET(
			int boardId,
			@ModelAttribute("findCriteria") FindCriteria findCriteria,
			Model model) throws Exception{
			
			model.addAttribute(boardService.read(boardId));
	}
	
	//DB修正処理
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPOST(
			BoardVO boardVO,
			FindCriteria findCriteria,
			RedirectAttributes reAttr) throws Exception{
		
			logger.info(findCriteria.toString());
			
			boardService.modify(boardVO);
			reAttr.addAttribute("page", findCriteria.getPage());
			reAttr.addAttribute("numPerPage", findCriteria.getNumPerPage());
			reAttr.addAttribute("findType", findCriteria.getFindType());
			reAttr.addAttribute("keyWord", findCriteria.getKeyWord());
			
			reAttr.addFlashAttribute("result", "success");
			
			logger.info(reAttr.toString());
			
			return "redirect:/findBoard/list";
	}
	
}	