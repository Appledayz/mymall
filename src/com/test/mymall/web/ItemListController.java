package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.ItemService;
import com.test.mymall.vo.Item;

@WebServlet("/ItemListController")
public class ItemListController extends HttpServlet {
	private ItemService itemService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ItemListController.doGet()");
		List<Item> list;
		HashMap<String, Integer> pagingInfo;
		int page = 1;
		itemService = new ItemService();
		
		//	page 요청이 있으면 받는다(초기값:1)
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		try {
			pagingInfo = new HashMap<String, Integer>();
			list = itemService.itemList(pagingInfo, page);
			request.setAttribute("list", list);
			request.setAttribute("pagingInfo", pagingInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/ItemList.jsp").forward(request, response);
	}
}
