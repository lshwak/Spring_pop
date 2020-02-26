package com.pop.service;

import com.pop.model.MessageVO;

public interface MessageService {
	public void addMessage(MessageVO vo) throws Exception;
	public MessageVO readMessage(String uid, int mid) throws Exception;
}
