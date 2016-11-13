package com.myproject.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMakerVO {

	private int totalBoardCount; 		// 전체 레코드 수
	private int startPageMaker;			// 페이지네이션 start
	private int endPageMaker;			// 페이지네이션 end
	private boolean prev;				// prev 버튼 유무
	private boolean next;				// next 버튼 유무
	private int perPageMakerNum = 10;	// 페이지네이션 단위
	private PageVO pageVO;				// 현재 페이지 정보와 페이지 당 레코드 수 정보를 가짐

	/* getter */
	public int getTotalBoardCount() {
		return totalBoardCount;
	}

	public int getStartPageMaker() {
		return startPageMaker;
	}

	public int getEndPageMaker() {
		return endPageMaker;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getPerPageMakerNum() {
		return perPageMakerNum;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	/* setter */
	public void setTotalBoardCount(int totalBoardCount) {
		this.totalBoardCount = totalBoardCount;
	}

	public void setStartPageMaker(int startPageMaker) {
		this.startPageMaker = startPageMaker;
	}

	public void setEndPageMaker(int endPageMaker) {
		this.endPageMaker = endPageMaker;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setPerPageMakerNum(int perPageMakerNum) {
		this.perPageMakerNum = perPageMakerNum;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	/* PageVO 정보를 이용해 PageMaker 만들기 */
	public void makePageMaker(PageVO pageVO, int totalBoardCount) {
		//             startPageMaker endPageMaker
		// 페이지   1 :        1             10
		// 페이지   3 :        1             10
		// 페이지 10 :        1             10
		// 페이지 11 :       11             20    <-    레코드 수가 20 * perPageNum 이상인 경우
		// 페이지 11 :       11             16    <-    레코드 수가 16 * perPageNum 인 경우
		
		this.pageVO = pageVO;
		this.totalBoardCount = totalBoardCount;
		
		endPageMaker = (int) (Math.ceil(pageVO.getPage() / (double) perPageMakerNum)) * perPageMakerNum;
		startPageMaker = (endPageMaker - perPageMakerNum) + 1;
		int tempEndPageMaker = (int) (Math.ceil(totalBoardCount / (double) pageVO.getPerPageNum()));
		endPageMaker = Math.min(endPageMaker, tempEndPageMaker);

		prev = (startPageMaker == 1) ? false : true;
		next = (endPageMaker * pageVO.getPerPageNum() < totalBoardCount) ? true : false;
	}
	
	public String makePageQuery(int page){
		UriComponents components = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", pageVO.getPerPageNum())
				.build();
		return components.toUriString();
	}
	
	public String makeSearchPageQuery(int page){
		UriComponents components = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", pageVO.getPerPageNum())
				.queryParam("searchType", ((SearchPageVO) pageVO).getSearchType())
				.queryParam("keyword", ((SearchPageVO) pageVO).getKeyword())
				.build();
		return components.toUriString();
	}

}
