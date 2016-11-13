package com.myproject.service;

import java.util.List;

import com.myproject.vo.BoardVO;
import com.myproject.vo.PageVO;

public interface BoardService {
	public List<BoardVO> getBoardList(PageVO pageVO);
	
	public int getTotalBoardCount(PageVO pageVO);
}
