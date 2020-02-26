package com.pop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pop.mapper.MessageMapper;
import com.pop.mapper.PointMapper;
import com.pop.model.MessageVO;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageMapper mm;
	@Autowired
	private PointMapper pm;
	@Transactional
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		mm.create(vo);
		pm.updatePoint(vo.getSender(), 10);
	}

	@Override
	public MessageVO readMessage(String uid, int mid) throws Exception {
		mm.updateState(mid);
		pm.updatePoint(uid, 5);
	
		return mm.readMessgae(mid);
	}

}
