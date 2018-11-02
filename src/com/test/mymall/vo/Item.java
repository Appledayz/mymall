package com.test.mymall.vo;

public class Item {
	private int no;
	private String name;
	private int price;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		System.out.println("setNo : "+no);
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setName : "+name);
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		System.out.println("setPrice : "+price);
		this.price = price;
	}
}
