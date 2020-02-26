package com.pop.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pop.model.Criteria;
import com.pop.model.ReplyVO;

@Repository
public class ReplyMapperImpl implements ReplyMapper {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.pop.mapper.ReplyMapper";
	
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		List list = sqlSession.selectList(namespace+".repboardList",bno);
		return list;
	}

	@Override
	public void RepWrite(ReplyVO vo) throws Exception {
		sqlSession.insert(namespace+".repboardWrite",vo);
	}

	@Override
	public void RepModify(ReplyVO vo) throws Exception {
		sqlSession.update(namespace+".repboardModify",vo);
	}

	@Override
	public void RepDel(int rno) throws Exception {
		sqlSession.delete(namespace+".repboardDel",rno);
	}
	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		System.out.println("mapper cri1="+cri);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		System.out.println("mapper cri2="+paramMap.get("cri"));
		
		List list = sqlSession.selectList(namespace+".repboardListPage",paramMap);
		return list;
	}
	@Override
	public int count(int bno) throws Exception {
		return sqlSession.selectOne(namespace+".count",bno);
	}
}
