package com.pop.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pop.mapper.BoardMapper;
import com.pop.model.BoardVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testBoardList() throws Exception {
		Logger.getLogger(""+boardMapper.boardList());
	}
	@Test
	public void testBoardDetail() throws Exception {
		BoardVO board = boardMapper.boardDetail(20);
		
		Logger.getLogger(""+board);
	}
	@Test
	public void testBoardWrite() throws Exception {
		
		BoardVO board = new BoardVO();
		board.setSubject("제목입니다.");
		board.setContent("내용입니다.");
		board.setWriter("작성자");
		board.setCnt(3);
		
		boardMapper.boardWrite(board);
	}
	@Test
	public void testBoardModify() throws Exception {
		BoardVO board = new BoardVO();
		board.setSubject("제목입니다잉.");
		board.setContent("내용입니다이옹.");
		board.setNo(30);
		
		boardMapper.boardModify(board);
	}
	@Test
	public void testBoardDel() throws Exception {
		BoardVO board = new BoardVO();
		board.setNo(33);
		boardMapper.boardDel(board);
	}
}
	