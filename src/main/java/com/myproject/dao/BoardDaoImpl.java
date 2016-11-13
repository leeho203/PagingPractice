package com.myproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.vo.BoardVO;
import com.myproject.vo.PageVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession sqlSession;

	private final String NAMESPACE = "com.myproject.mapper.boardMapper";

	@Override
	public List<BoardVO> getBoardList(PageVO pageVO) {
		return sqlSession.selectList(NAMESPACE + ".getBoardList", pageVO);
	}

	@Override
	public int getTotalBoardCount(PageVO pageVO) {
		return sqlSession.selectOne(NAMESPACE + ".getTotalBoardCount", pageVO);
	}
}
