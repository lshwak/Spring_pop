package com.pop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pop.mapper.ReplyMapper;
import com.pop.model.Criteria;
import com.pop.model.ReplyVO;

@Service
public class RelpyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper rm;
	
	@Override
	public List<ReplyVO> Replylist(int bno) throws Exception{
		return rm.list(bno);
	}
	@Override
	public void RepWrite(ReplyVO vo) throws Exception {
		rm.RepWrite(vo);
	}
	@Override
	public void RepModify(ReplyVO vo) throws Exception {
		rm.RepModify(vo);
	}
	@Override
	public void RepDel(int rno) throws Exception {
		rm.RepDel(rno);
	}
	@Override
	public List<ReplyVO> Replylist(int bno, Criteria cri) throws Exception {
		System.out.println("service cir="+cri);
		return rm.listPage(bno, cri); 
	}
	@Override
	public int count(int bno) throws Exception {
		return rm.count(bno);
	}
}
