package com.myproject.vo;

public class SearchPageVO extends PageVO {

	String searchType;
	String keyword;

	/* getter */
	public String getSearchType() {
		return searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	/* setter */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
