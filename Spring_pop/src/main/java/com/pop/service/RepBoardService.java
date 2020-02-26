package com.pop.service;

import java.util.List;

import com.pop.model.Criteria;
import com.pop.model.RepBoardVO;

public interface RepBoardService {
	// 게시판 리스트
		public List<RepBoardVO> repboardList() throws Exception;
		
		// 게시판 리스트 (페이징 처리)
		public List<RepBoardVO> repboardListPaging(Criteria cri) throws Exception;
			
		// 게시판 제목을 클릭했을 때
		public RepBoardVO repboardDetail(int no) throws Exception;
		
		// board테이블의 전체 갯수 : 페이징의  realEnd를 알기 위해서.
		public int RepboardCount(Criteria cri) throws Exception;
		
		// 게시판 글 수정
		public void RepboardModify(RepBoardVO board)throws Exception;
		
		// 게시판 글 삭제
		public void RepboardDel(RepBoardVO board)throws Exception;
		
		// 게시판 글 쓰기
		public void RepboardWrite(RepBoardVO board)throws Exception;
}
