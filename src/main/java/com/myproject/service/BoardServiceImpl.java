package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.BoardDao;
import com.myproject.vo.BoardVO;
import com.myproject.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<BoardVO> getBoardList(PageVO pageVO) {
		return boardDao.getBoardList(pageVO);
	}

	@Override
	public int getTotalBoardCount(PageVO pageVO) {
		return boardDao.getTotalBoardCount(pageVO);
	}
}
