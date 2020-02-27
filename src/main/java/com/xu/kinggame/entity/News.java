package com.xu.kinggame.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class News {

	private Long newId;
	private String newTitle;
	private Long newKindId;
	private String newImage;
	private String newContent;
	private Byte newStatus;
	private Long newView;
	private Byte isDeleted;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;

	public Long getNewId() {
		return newId;
	}

	public void setNewId(Long newId) {
		this.newId = newId;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public Long getNewKindId() {
		return newKindId;
	}

	public void setNewKindId(Long newKindId) {
		this.newKindId = newKindId;
	}

	public String getNewImage() {
		return newImage;
	}

	public void setNewImage(String newImage) {
		this.newImage = newImage;
	}

	public String getNewContent() {
		return newContent;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public Byte getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(Byte newStatus) {
		this.newStatus = newStatus;
	}

	public Long getNewView() {
		return newView;
	}

	public void setNewView(Long newView) {
		this.newView = newView;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "News [newId=" + newId + ", newTitle=" + newTitle + ", newKindId=" + newKindId + ", newImage=" + newImage
				+ ", newContent=" + newContent + ", newStatus=" + newStatus + ", newView=" + newView + ", isDeleted="
				+ isDeleted + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
    
    
}
