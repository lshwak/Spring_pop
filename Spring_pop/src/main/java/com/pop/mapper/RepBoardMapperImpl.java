package com.pop.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pop.model.RepBoardVO;
import com.pop.model.Criteria;

@Repository
public class RepBoardMapperImpl implements RepBoardMapper {
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.pop.mapper.RepBoardMapper";
	
	// 전체 목록 리스트
	@Override
	public List<RepBoardVO> repboardList() throws Exception {
		List list = sqlSession.selectList(namespace+".repboardList");
		return list;
	}
	// 전체 목록 리스트 (페이징 처리)
	@Override
	public List<RepBoardVO> repboardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".repboardListPage",cri);
		return list;
	}
	
	// board테이블의 전체 갯수 : 페이징의  realEnd를 알기 위해서.
	public int repboardCount(Criteria cri) throws Exception {
		int cnt=sqlSession.selectOne(namespace+".repboardCount",cri);
		return cnt;
	}
	
	// 제목 클릭 시 상세 페이지
	@Override
	public RepBoardVO repboardDetail(int no) throws Exception{
		// selectOne은 select된 결과가 한 건 일때 사용하는 메소드.
		RepBoardVO boardvo = sqlSession.selectOne(namespace+".repboardDetail",no);
		return boardvo;
	}
	// 게시판 글 쓰기
	@Override
	public void repboardWrite(RepBoardVO board) throws Exception {
		sqlSession.insert(namespace+".repboardWrite",board);
		
	}
	// 게시판 글 수정
	@Override
	public void repboardModify(RepBoardVO board) throws Exception {
		sqlSession.update(namespace+".repboardModify",board);
		
	}
	// 게시판 글 삭제
	@Override
	public void repboardDel(RepBoardVO board) throws Exception {
		sqlSession.delete(namespace+".repboardDel", board);
		
	}
}
