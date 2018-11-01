package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

@WebServlet("/ItemListController")
public class ItemListController extends HttpServlet {
	private ItemDao itemDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ItemListController.doGet()");
		try {
			ArrayList<Item> list = itemDao.itemList();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/ItemList.jsp").forward(request, response);
	}
}
