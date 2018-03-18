package com.spring.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.BoardService;
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
		
		model.addAttribute("list", boardService.listCriteria(findCriteria));
		PagingMaker pagingMaker = new PagingMaker();
		pagingMaker.setPageCriteria(findCriteria);
		pagingMaker.setTotalData(boardService.countData(findCriteria));
		
		model.addAttribute("pagingMaker", pagingMaker);
	}
}	