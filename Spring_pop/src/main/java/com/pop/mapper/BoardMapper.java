package com.pop.mapper;

import java.util.List;

import com.pop.model.BoardVO;
import com.pop.model.Criteria;

public interface BoardMapper {
	// 전체 목록 리스트
	public List<BoardVO> boardList()throws Exception;
	
	// 전체 목록 리스트 (페이징 처리)
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception;
	
	// board테이블의 전체 갯수 : 페이징의  realEnd를 알기 위해서.
	public int boardCount(Criteria cri) throws Exception;
	
	// 제목을 클릭했을 때 상세 페이지
	public BoardVO boardDetail(int no)throws Exception;	
	//public void boardWrite(String subject, String content, String writer, int cnt);
	// 위, 아래 코드는 같다.
	
	// 게시판 글 쓰기
	public void boardWrite(BoardVO board,String filename)throws Exception;
	// 게시판 글 수정
	public void boardModify(BoardVO board)throws Exception;
	// 게시판 글 삭제
	public void boardDel (BoardVO board)throws Exception; 
	// 게시판 글 쓰기 할 때 파일 업로드
	public void addAttach(String filename) throws Exception;
}
