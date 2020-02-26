package com.pop.controller;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pop.model.BoardVO;
import com.pop.model.Criteria;
import com.pop.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardListPaging {

	@Autowired
	private BoardService boardservice;
	
	@Test
	public void testPaging() throws Exception {
		Criteria cri = new Criteria();
		
		cri.setPageNum(2);
		cri.setAmount(10);
		
		List<BoardVO> list = boardservice.boardListPaging(cri);
		
		list.forEach(board->Logger.getLogger(""+board)); 
	}
}
