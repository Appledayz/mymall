package com.test.mymall.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	private SqlSession sqlSession;
	//	RemoveMemberController에서 MemberService.removeMember()호출
	public void removeMember(int no) {
		System.out.println("MemberService.removeMember()");
		try {
			sqlSession = DBHelper.getSqlSession();
			//	1 function
			memberDao = new MemberDao();
			memberDao.deleteMember(sqlSession, no);
			//	2 function
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(sqlSession, no);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		memberDao = new MemberDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao.insertMember(sqlSession, member);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
