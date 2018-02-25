package com.spring.vo;

import java.sql.Date;

public class BoardVO {
	
	private Integer boardId;
	private String subject;
	private String content;
	private String writer;
	private Date registerDate;
	private int hit;
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}
