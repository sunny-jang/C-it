package com.cit.news.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class NewsDto {
	private int bNum;
	private String title;
	private String content;
	private String uId;
	private String category;
	private String author;
	private String newsLink;
	private Date enrollDate;
	private int views;
	private int refNum;
	private ArrayList<String> imagePathList;
	
	
	public ArrayList<String> getImagePathList() {
		return imagePathList;
	}

	public void setImagePathList(ArrayList<String> imagePathList) {
		this.imagePathList = imagePathList;
	}

	public NewsDto() {}
	
	public NewsDto(int bNum, String title, String content, String uId, String category, String author, String newsLink,
			Date enrollDate, int views, int refNum) {
		super();
		this.bNum = bNum;
		this.title = title;
		this.content = content;
		this.uId = uId;
		this.category = category;
		this.author = author;
		this.newsLink = newsLink;
		this.enrollDate = enrollDate;
		this.views = views;
		this.refNum = refNum;
	}
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
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
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getRefNum() {
		return refNum;
	}

	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}

	@Override
	public String toString() {
		return "NewsDto [bNum=" + bNum + ", title=" + title + ", content=" + content + ", uId=" + uId + ", category="
				+ category + ", author=" + author + ", newsLink=" + newsLink + ", enrollDate=" + enrollDate + ", views="
				+ views + ", refNum=" + refNum + ", imagePathList=" + imagePathList + "]";
	}

	
}
