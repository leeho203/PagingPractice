package com.myproject.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.service.BoardService;
import com.myproject.vo.BoardVO;
import com.myproject.vo.PageMakerVO;
import com.myproject.vo.PageVO;
import com.myproject.vo.SearchPageVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String getBoardList(Model model, SearchPageVO searchPageVO, PageMakerVO pageMakerVO) {

		/* pageVO를 이용해 boardList 만들기 */
		List<BoardVO> boardList = boardService.getBoardList(searchPageVO);

		/* pageVO를 이용해 pageMakerVO 만들기 */
		int totalBoardCount = boardService.getTotalBoardCount(searchPageVO);
		pageMakerVO.makePageMaker(searchPageVO, totalBoardCount);

		/* boardList, pageMakerVO 를 뷰에 전달 */
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageMakerVO", pageMakerVO);

		/*	searchType, keyword 이전 요청 정보를 전달해서 뷰에 표시하도록 하기 위함	*/
		model.addAttribute("searchPageVO", searchPageVO);
		
		return "boardList";
	}
}
