package com.study.board.db;

import java.sql.Date;


public class BoardDTO {

	private int bno;
	private String name;
	private String pw;
	private String title;
	private String content;
	private Date date;
	private int readcnt;
	
	// getter/setter
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	
	// toString()
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", name=" + name + ", pw=" + pw + ", title=" + title + ", content=" + content
				+ ", date=" + date + ", readcnt=" + readcnt + "]";
	}
	
	
}
