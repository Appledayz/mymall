package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;

public class MemberItemDao {
	ResultSet rs;
	Connection conn;
	Statement stmt;
	//Member INNER JOIN item
	public ArrayList<HashMap<String, Object>> getMemberItemList(Connection conn, int memberNo) throws Exception{
		System.out.println("MemberItemDao.getMemberItemList()");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		conn = DBHelper.getConnection();
		rs = null;
		String sql = "select mi.no, mi.order_date, mi.item_no, i.name, i.price" + 
				"		from member_item mi inner join item i" + 
				"		on mi.item_no = i.no" + 
				"		where mi.member_no="+memberNo;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			//	MemberItemJoinItem -> HashMap
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberItemNo", rs.getInt("mi.no"));
			map.put("itemPrice", rs.getInt("i.price"));
			map.put("itemName", rs.getInt("i.name"));
			map.put("orderDate", rs.getInt("mi.order_date"));
			list.add(map);
		}
		DBHelper.close(rs, stmt, conn);
		return list;
	}
	public void deleteMemberItem(Connection conn, int no) {
		System.out.println("MemberItemDao.deleteMemberItem()");
		
	}
}
