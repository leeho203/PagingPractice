package com.myproject.vo;

import java.util.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date moddate;
	private int viewcnt;
	private int replycnt;

	public int getBno() {
		return bno;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriter() {
		return writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public Date getModdate() {
		return moddate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public int getReplycnt() {
		return replycnt;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
}
