package com.pop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pop.mapper.BoardMapper;
import com.pop.model.BoardVO;
import com.pop.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper bm;
	// 게시판 리스트
	@Override
	public List<BoardVO> boardList() throws Exception {		
		return bm.boardList();
	}
	// 게시판 리스트(페이징 처리)
	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {		
		return bm.boardListPaging(cri);
	}
	// 게시판 제목을 클릭 했을 때
	@Override
	public BoardVO boardDetail(int no) throws Exception {
		return bm.boardDetail(no);
	}
	// board테이블의 전체 갯수 : 페이징의  realEnd를 알기 위해서.
	@Override
	public int boardCount(Criteria cri) throws Exception {
		return bm.boardCount(cri);
	}
	// 글 수정
	@Override
	public void boardModify(BoardVO board) throws Exception {
		bm.boardModify(board);
	}
	// 글 삭제
	@Override
	public void boardDel(BoardVO board) throws Exception {
		bm.boardDel(board);
	}
	// 글 쓰기
	@Transactional
	@Override
	public void boardWrite(BoardVO board,String filename) throws Exception {
		bm.boardWrite(board,filename);
		
		/*
		 * String[] files = board.getFiles();
		 * 
		 * if(files == null) {return;}
		 * 
		 * for(String filename : files) { bm.addAttach(filename); }
		 */
	}

}
