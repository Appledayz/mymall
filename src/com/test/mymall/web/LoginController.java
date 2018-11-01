package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.service.LoginService;
import com.test.mymall.vo.Member;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private LoginService loginService;
	private Member member;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController.doPost()");
		member = new Member();
		loginService = new LoginService();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member = loginService.Login(member);
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", member);
		response.sendRedirect(request.getContextPath()+"/IndexController");
	}

}
