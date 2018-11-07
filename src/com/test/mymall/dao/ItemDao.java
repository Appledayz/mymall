package com.test.mymall.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Item;

public class ItemDao {
	Item item;
	public int insertItem(SqlSession sqlSession, Item item) throws Exception {
		System.out.println("ItemDao.insertItem()");
		String sql = "INSERT INTO item VALUES(null,"+item.getName()+","+item.getPrice()+")";
		return sqlSession.insert("com.test.mymall.dao.ItemMapper.inserItem", item);
	}
	
	public List<Item> selectItemList(SqlSession sqlSession, int rowPerPage, int currentPage) throws Exception{
		System.out.println("ItemDao.selectItemList()");
		int startRow = (currentPage-1)*rowPerPage;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
//		sqlSession.selectList(id명,매개변수)
		return sqlSession.selectList("com.test.mymall.dao.ItemMapper.selectItemList", map);
	}
	
	public int getTotalItemRow(SqlSession sqlSession) throws SQLException {
		System.out.println("ItemDao.getTotalItemRow()");
		int result = 0;
		String sql = "SELECT COUNT(*) FROM item";
		return result;
	}
}
