package com.kwan.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kwan.domain.BoardVO;
import com.kwan.domain.Criteria;
import com.kwan.domain.PageMaker;
import com.kwan.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		log.info("regist get ------> ");
		
	}
	
	//@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping(value="/register")
	// public String registerPOST(BoardVO board, Model model) throws Exception {
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		log.info("regist post ------> ");
		log.info(board.toString());
		service.regist(board);
		// model.addAttribute("result", "success");
		rttr.addFlashAttribute("result", "success");
		// return "/board/success"; //URL에 result 값이 나옴.
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		log.info("listAll ----- > ");
		model.addAttribute("list", service.listAll());
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		log.info("read -----> ");
		model.addAttribute(service.read(bno));
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		log.info("modify get ------ >");
		model.addAttribute(service.read(bno)); // get 방식
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		log.info("modify post ------ >");
		service.modify(board);
		rttr.addFlashAttribute("result", "success"); // post 방식
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		log.info("criteria ----- > ");
		model.addAttribute("list", service.listCriteria(cri));
		
	}
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception {
		log.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		System.out.println("ggggg");
	}

}
