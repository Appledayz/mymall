package com.test.mymall.service;

import java.sql.Connection;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

public class LoginService {
	MemberDao memberDao;
	Connection conn;
	public Member Login(Member member) {
		System.out.println("LoginService.Login()");
		memberDao = new MemberDao();
		try {
			conn = DBHelper.getConnection();
			member = memberDao.login(conn, member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
		return member;
	}
}
