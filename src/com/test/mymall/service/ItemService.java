package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	private Connection conn;
	
	public ArrayList<Item> itemList(HashMap<String, Integer> pagingInfo, int page){
		ArrayList<Item> list = new ArrayList<Item>();
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
			conn = DBHelper.getConnection();
			list = itemDao.itemList(conn, rowPerPage, currentPage);
			totalItemRow = itemDao.getTotalItemRow(conn);
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
			DBHelper.close(null, null, conn);
		}
		return list;
	}
	
	
	public void insertItem(Item item) {
		itemDao = new ItemDao();
		try {
			conn = DBHelper.getConnection();
			itemDao.insertItem(conn, item);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
		
	}
}
