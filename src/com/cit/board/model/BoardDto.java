package com.cit.board.model;

import java.sql.Date;
import java.util.ArrayList;

public class BoardDto {
	private int num;
	private String title;
	private Date date;
	private int views;
	private String cont;
	private String id;
	private String cate;
	private int rNum;
	private ArrayList<String> imagePathList;
	
	public BoardDto() {}
	
	public BoardDto(int num,String title,Date date,int views,String cont,String id,String cate,int rNum) {
		this.num = num;
		this.title = title;
		this.date = date;
		this.views = views;
		this.cont = cont;
		this.id = id;
		this.cate = cate;
		this.rNum = rNum;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public ArrayList<String> getImagePathList() {
		return imagePathList;
	}

	public void setImagePathList(ArrayList<String> imagePathList) {
		this.imagePathList = imagePathList;
	}

	@Override
	public String toString() {
		return num+title+date+views+cont+id+cate+rNum;
	}

	

}
