package com.test.mymall.service;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

public class LoginService {
	MemberDao memberDao;
	private SqlSession sqlSession;
	
	public Member Login(Member member) {
		System.out.println("LoginService.Login()");
		memberDao = new MemberDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			member = memberDao.login(sqlSession, member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return member;
	}
}
