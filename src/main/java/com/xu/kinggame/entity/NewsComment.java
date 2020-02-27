package com.xu.kinggame.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewsComment {

	private Long commentId;
	private Long newId;
	private String commentator;
	private String commentBody;
	private Byte commentStatus;
	private Byte isDeleted;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getNewId() {
		return newId;
	}
	public void setNewId(Long newId) {
		this.newId = newId;
	}
	public String getCommentator() {
		return commentator;
	}
	public void setCommentator(String commentator) {
		this.commentator = commentator;
	}
	public String getCommentBody() {
		return commentBody;
	}
	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
	public Byte getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(Byte commentStatus) {
		this.commentStatus = commentStatus;
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "NewsComment [commentId=" + commentId + ", newId=" + newId + ", commentator=" + commentator
				+ ", commentBody=" + commentBody + ", commentStatus=" + commentStatus + ", isDeleted=" + isDeleted
				+ ", createTime=" + createTime + "]";
	}
	
	
}
