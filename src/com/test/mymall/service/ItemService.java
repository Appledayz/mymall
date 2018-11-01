package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	private ItemDao itemDao;
	private Connection conn;
	public ArrayList<Item> itemList(){
		ArrayList<Item> list = new ArrayList<>();
		try {
			list = itemDao.itemList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
		return list;
	}
}
