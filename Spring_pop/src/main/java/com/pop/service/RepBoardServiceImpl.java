package com.pop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pop.mapper.RepBoardMapper;
import com.pop.model.Criteria;
import com.pop.model.RepBoardVO;

@Service
public class RepBoardServiceImpl implements RepBoardService {
	
	@Autowired
	RepBoardMapper rbm;
	// 게시판 리스트
	@Override
	public List<RepBoardVO> repboardList() throws Exception {		
		return rbm.repboardList();
	}
	// 게시판 리스트(페이징 처리)
	@Override
	public List<RepBoardVO> repboardListPaging(Criteria cri) throws Exception {		
		return rbm.repboardListPaging(cri);
	}
	// 게시판 제목을 클릭 했을 때
	@Override
	public RepBoardVO repboardDetail(int no) throws Exception {
		return rbm.repboardDetail(no);
	}
	// board테이블의 전체 갯수 : 페이징의  realEnd를 알기 위해서.
	@Override
	public int RepboardCount(Criteria cri) throws Exception {
		return rbm.repboardCount(cri);
	}
	// 글 수정
	@Override
	public void RepboardModify(RepBoardVO board) throws Exception {
		rbm.repboardModify(board);
	}
	// 글 삭제
	@Override
	public void RepboardDel(RepBoardVO board) throws Exception {
		rbm.repboardDel(board);
	}
	// 글 쓰기
	@Override
	public void RepboardWrite(RepBoardVO board) throws Exception {
		rbm.repboardWrite(board);
	}
	
}
