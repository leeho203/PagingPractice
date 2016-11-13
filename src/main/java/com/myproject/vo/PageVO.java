package com.myproject.vo;

public class PageVO {
	int page = 1;
	int perPageNum = 20;

	public int getPage() {
		return page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getStartRecord() {
		return (page - 1) * perPageNum;
	}
}
