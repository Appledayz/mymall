package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public void insertItem(Item item) throws Exception {
		System.out.println("ItemDao.insertItem()");
		conn = DBHelper.getConnection();
		String sql = "";
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
	public ArrayList<Item> itemList() throws Exception{
		System.out.println("ItemDao.itemList()");
		ArrayList<Item> list = new ArrayList<Item>();
		String sql = "SELECT * FROM item";
		conn = DBHelper.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		return list;
	}
}
