package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;

public class MemberItemDao {
	//Member INNER JOIN item
	public List<Object> getMemberItemList(SqlSession sqlSession, int memberNo) throws Exception{
		System.out.println("MemberItemDao.getMemberItemList()");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		sqlSession = DBHelper.getSqlSession();
		String sql = "select mi.no, mi.order_date, mi.item_no, i.name, i.price" + 
				"		from member_item mi inner join item i" + 
				"		on mi.item_no = i.no" + 
				"		where mi.member_no="+memberNo;
		//	MemberItemJoinItem -> HashMap
		return sqlSession.selectList("com.test.mymall.dao.MemberItemMapper.getMemberItemList", memberNo);
	}
	public void deleteMemberItem(SqlSession sqlSession, int no) {
		System.out.println("MemberItemDao.deleteMemberItem()");
		
	}
}
