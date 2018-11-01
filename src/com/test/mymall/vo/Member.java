package com.test.mymall.vo;

public class Member {
	private int no;
	private String id;
	private String pw;
	private int level;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println("setId() Member.java");
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		System.out.println("setPw() Member.java");
		this.pw = pw;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		System.out.println("setLevel() Member.java");
		this.level = level;
	}
}
