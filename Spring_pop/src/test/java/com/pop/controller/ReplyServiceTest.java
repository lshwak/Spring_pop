package com.pop.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pop.model.ReplyVO;
import com.pop.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyServiceTest {
	@Autowired
	private ReplyService rbservice;
	/*@Test
	public void testrepServiceIns() throws Exception {
		ReplyVO rv = new ReplyVO();
		rv.setBno(1);
		rv.setReplytext("댓글입니다.");
		rv.setReplyer("관리자");
		
		rbservice.RepWrite(rv);
	}
	@Test
	public void testrepServiceUp() throws Exception {
		ReplyVO rv = new ReplyVO();
		
		rv.setReplytext("댓글을 수정합니다.");
		rv.setRno(1);
		
		rbservice.RepModify(rv);
	}*/
	@Test
	public void testrepServiceDe() throws Exception {
		ReplyVO rv = new ReplyVO();
		rv.setRno(2);
		rbservice.RepDel(3);
	}
	@Test
	public void testrepServiceSe() throws Exception {
		//ReplyVO rv = new ReplyVO();
		//rv.setBno(1);
		rbservice.Replylist(1);
	}
	
}
