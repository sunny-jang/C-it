package com.cit.news.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.cit.board.model.BoardDto;

public class NewsDto extends BoardDto {
	private String author;
	private String newsLink;
	
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
		super(bNum, title, new java.sql.Date(enrollDate.getTime()), views, content, uId, category, refNum);
		
		this.author = author;
		this.newsLink = newsLink;
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
		return "NewsDto [author=" + author + ", newsLink=" + newsLink + ", imagePathList=" + imagePathList
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
