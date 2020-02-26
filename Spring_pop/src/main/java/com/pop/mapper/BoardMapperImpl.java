package com.pop.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pop.model.BoardVO;
import com.pop.model.Criteria;

@Repository
public class BoardMapperImpl implements BoardMapper {
	
	@Inject			// 또는 @Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.pop.mapper.BoardMapper";
	
	// 전체 목록 리스트
	@Override
	public List<BoardVO> boardList() throws Exception {
		List list = sqlSession.selectList(namespace+".boardList");
		return list;
	}
	// 전체 목록 리스트 (페이징 처리)
	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPage",cri);
		return list;
	}
	
	// board테이블의 전체 갯수 : 페이징의  realEnd를 알기 위해서.
	public int boardCount(Criteria cri) throws Exception {
		int cnt=sqlSession.selectOne(namespace+".boardCount",cri);
		return cnt;
	}
	
	// 제목 클릭 시 상세 페이지
	@Override
	public BoardVO boardDetail(int no) throws Exception{
		// selectOne은 select된 결과가 한 건 일때 사용하는 메소드.
		BoardVO boardvo = sqlSession.selectOne(namespace+".boardDetail",no);
		return boardvo;
	}
	// 게시판 글 쓰기
	@Override
	public void boardWrite(BoardVO board,String filename) throws Exception {
		System.out.println("filename="+filename+"board="+board);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("filename", filename);
		paramMap.put("board", board);
		sqlSession.insert(namespace+".boardWrite",paramMap);
	}
	// 게시판 글 수정
	@Override
	public void boardModify(BoardVO board) throws Exception {
		sqlSession.update(namespace+".boardModify",board);
		
	}
	// 게시판 글 삭제
	@Override
	public void boardDel(BoardVO board) throws Exception {
		sqlSession.delete(namespace+".boardDel", board);
		
	}
	// 게시판 글 쓰기 할 때 파일 업로드
	@Override
	public void addAttach(String filename) throws Exception {
		sqlSession.insert(namespace+".addAttach", filename);
		
	}
	


}
