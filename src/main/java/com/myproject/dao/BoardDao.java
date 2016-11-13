package com.myproject.dao;

import java.util.List;

import com.myproject.vo.BoardVO;
import com.myproject.vo.PageVO;

public interface BoardDao {

	public List<BoardVO> getBoardList(PageVO pageVO);
	
	public int getTotalBoardCount(PageVO pageVO);
}
