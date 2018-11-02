package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	Item item;
	public void insertItem(Connection conn, Item item) throws Exception {
		System.out.println("ItemDao.insertItem()");
		String sql = "INSERT INTO item VALUES(null,"+item.getName()+","+item.getPrice()+")";
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		DBHelper.close(null, stmt, null);
	}
	public ArrayList<Item> itemList(Connection conn, int rowPerPage, int currentPage) throws Exception{
		System.out.println("ItemDao.itemList()");
		ArrayList<Item> list = new ArrayList<Item>();
		int startRow = (currentPage-1)*rowPerPage;
		String sql = "SELECT * FROM item limit "+startRow+","+rowPerPage;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			item = new Item();
			item.setNo(rs.getInt("no"));
			item.setName(rs.getString("name"));
			item.setPrice(rs.getInt("price"));
			list.add(item);
		}
		DBHelper.close(rs, stmt, null);
		return list;
	}
	
	public int getTotalItemRow(Connection conn) throws SQLException {
		System.out.println("ItemDao.getTotalItemRow()");
		int result = 0;
		String sql = "SELECT COUNT(*) FROM item";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			result = rs.getInt(1);
		}
		DBHelper.close(rs, stmt, null);
		return result;
	}
}
