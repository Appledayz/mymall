package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/AddMemberController")
public class AddMemberController extends HttpServlet {
	//	1. 라우터
	//	2. 모델호출
	//	3. 뷰 렌더링
	private MemberService memberService;
	private Member member;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/AddMember.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
		member = new Member();
		memberService = new MemberService();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		memberService.addMember(member);
		response.sendRedirect(request.getContextPath()+"/IndexController");
	}
}
