package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	private SqlSession sqlSession;
	
	public List<Item> itemList(HashMap<String, Integer> pagingInfo, int page){
		List<Item> list = new ArrayList<Item>();
		itemDao = new ItemDao();
		int rowPerPage = 15;
		int currentPage=1;
		int totalItemRow=0;
		int lastPage=0;
		int pageButtonPerPage=10;
		int pageButtonBegin=1;
		if(page>0) {
			currentPage=page;
		}
		try {
			sqlSession = DBHelper.getSqlSession();
			list = itemDao.selectItemList(sqlSession, rowPerPage, currentPage);
			totalItemRow = itemDao.getTotalItemRow(sqlSession);
			lastPage = totalItemRow/rowPerPage;
			if(totalItemRow%rowPerPage != 0) {
				lastPage++;
			}
			pageButtonBegin = ((currentPage-1)/pageButtonPerPage)*pageButtonPerPage;
			if(pageButtonBegin > (lastPage-pageButtonPerPage)) {
				pageButtonPerPage = lastPage%pageButtonPerPage;
			}
			System.out.println("currentPage : "+currentPage);
			System.out.println("pageButtonBegin : "+pageButtonBegin);
			System.out.println("pageButtonPerPage : "+pageButtonPerPage);
			System.out.println("lastPage : "+lastPage);
			
			pagingInfo.put("totalItemRow", totalItemRow);
			pagingInfo.put("currentPage", currentPage);
			pagingInfo.put("rowPerPage", rowPerPage);
			pagingInfo.put("lastPage", lastPage);
			pagingInfo.put("pageButtonBegin", pageButtonBegin);
			pagingInfo.put("pageButtonPerPage", pageButtonPerPage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	
	public void insertItem(Item item) {
		itemDao = new ItemDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			itemDao.insertItem(sqlSession, item);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
}
