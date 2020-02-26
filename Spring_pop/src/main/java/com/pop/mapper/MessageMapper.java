package com.pop.mapper;

import com.pop.model.MessageVO;

public interface MessageMapper {
	public void create(MessageVO vo) throws Exception;		// 메세지 생성
	public MessageVO readMessgae(int mid) throws Exception;	// 메세지 조회
	public void updateState (int mid) throws Exception;		// 메세지 상황수정
}
