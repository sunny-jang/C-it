package com.cit.news.model;

public class NewsDto {
	private int bNum;
	private String title;
	private String content;
	private String uId;
	private String category;
	private String author;
	private String newsLink;
	
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
	@Override
	public String toString() {
		return "NewsDto [bNum=" + bNum + ", title=" + title + ", content=" + content + ", uId=" + uId + ", category="
				+ category + ", author=" + author + ", newsLink=" + newsLink + "]";
	}
	
	
}
