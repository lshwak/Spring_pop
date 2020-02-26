package com.pop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pop.model.BoardVO;
import com.pop.model.Criteria;
import com.pop.model.PageVO;
import com.pop.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/* 게시글 목록 list 
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void listGet(Model model) throws Exception{
		//select 전체
		//logger.info("list 결과="+bservice.boardList());
		//select 전체 목록을 Model 객체에 저장 후 list.jsp에 실어서 보낸다.
		model.addAttribute("list", bservice.boardList());
	}*/
	
	/*게시글 목록 리스트(페이징 처리 된거)*/
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void listGet(Criteria cri,Model model) throws Exception{
		
		int total = bservice.boardCount(cri);
		
		PageVO pv = new PageVO(cri, total);
		//select 전체 목록을 Model 객체에 저장 후 list.jsp에 실어서 보낸다.
		logger.info("keyword="+cri.getKeyword());
		logger.info("pv="+pv.getStartPage());
		logger.info("total="+total);
		model.addAttribute("list", bservice.boardListPaging(cri));
		model.addAttribute("page", pv);
	}
	
	/* 글 쓰기를 위한 controller */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registGet() throws Exception{
		logger.info("regist get......");
		return "board/write";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(BoardVO board) throws Exception{
		logger.info("regist post......"+board);
		
		String filename=board.getFilename().getOriginalFilename();
		logger.info("regist post..."+board.getSubject());
		logger.info("regist post..."+filename);
		
		bservice.boardWrite(board, filename);		//글 쓰기 한 후
		return "redirect:list";
	}
	/* 글 상세 내용*/
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detailGet(@RequestParam int no,Model model) throws Exception {
		logger.info("detail get......"+no);
		
		model.addAttribute("detail", bservice.boardDetail(no));
	}
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public void modifyGet(@RequestParam int no,Model model) throws Exception {
		
		logger.info("modify get......");
		model.addAttribute("modify", bservice.boardDetail(no));
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modifyPost(BoardVO board) throws Exception {
		
		logger.info("modify get......");
		bservice.boardModify(board);
		return "redirect:detail?no="+board.getNo();
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	//public void deleteGet(@RequestParam int no) {
	public String delectGet(BoardVO board) throws Exception {
		logger.info("no="+board.getNo());
		bservice.boardDel(board);
		return "redirect:list";
	}
	@RequestMapping(value="replyboard", method=RequestMethod.GET)
	public void replyGET() throws Exception{
		logger.info("aaa");
		//logger.info("list 결과="+bservice.boardList());
		//select 전체 목록을 Model 객체에 저장 후 list.jsp에 실어서 보낸다.
		
	}
}





















