package com.spring.vo;

import java.sql.Date;

public class ReplyVO {
	
	private Integer replyId;
	private Integer boardId;
	private String replyContent;
	private String replyer;
	private Date registerDate;
	private Date updateDate;
	
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", boardId=" + boardId
				+ ", replyContent=" + replyContent + ", replyer=" + replyer
				+ ", registerDate=" + registerDate + ", updateDate="
				+ updateDate + "]";
	}
	
}
