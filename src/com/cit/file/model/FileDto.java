package com.cit.file.model;

public class FileDto {
	private String path;
	private String cName;
	private int bNum;
	
	public FileDto() {};
	
	public FileDto(String path, String cName, int bNum) {
		super();
		this.path = path;
		this.cName = cName;
		this.bNum = bNum;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getBNum() {
		return bNum;
	}
	public void setBNum(int bNum) {
		bNum = bNum;
	}
	
	@Override
	public String toString() {
		return "FileDto [path=" + path + ", cName=" + cName + ", BNum=" + bNum + "]";
	}
	
	
}
