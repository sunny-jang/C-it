package com.javateam.project.entity;

import java.sql.Date;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String gender;
	private Date birth;
	private String job;
	private String path;
	
	
	public MemberDto() {
		
	}
	
	public MemberDto(String id,String pw, String name, String email, String gender, Date birth, String job, String path) {
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.email=email;
		this.gender=gender;
		this.birth=birth;
		this.job=job;
		this.path=path;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		
		return id+pw+name+email+gender+birth+job+path;
	}
}
