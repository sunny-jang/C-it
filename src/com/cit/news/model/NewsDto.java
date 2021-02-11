package com.cit.news.model;

public class NewsDto {
	private int num;
	private String author;
	private String newsLink;
	
	public NewsDto() {}
	public NewsDto(int num, String author, String newsLink) {
		this.num = num;
		this.author = author;
		this.newsLink = newsLink;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
		return num+author+newsLink;
	}
}
