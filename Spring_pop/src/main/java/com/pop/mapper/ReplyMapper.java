package com.pop.mapper;

import java.util.List;

import com.pop.model.Criteria;
import com.pop.model.ReplyVO;

public interface ReplyMapper {
	// 댓글 조회
	public List<ReplyVO> list(int bno) throws Exception;
	// 댓글 쓰기
	public void RepWrite(ReplyVO vo) throws Exception;
	// 댓글 수정
	public void RepModify(ReplyVO vo) throws Exception;
	// 댓글 삭제
	public void RepDel(int rno) throws Exception;
	// 댓글 조회(페이징 처리)
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception;
	// 각 게시물의 댓글 전체 갯수
	public int count(int bno) throws Exception;
}
