package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	public Member login(SqlSession sqlSession, Member member) throws Exception {
		System.out.println("MemberDao.login()");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", member.getId());
		map.put("pw", member.getPw());
		sqlSession = DBHelper.getSqlSession();
		int loginCheck = sqlSession.selectOne("com.test.mymall.dao.MemberMapper.login", map);
		if(loginCheck == 1) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패, 아이디와 비밀번호를 다시 확인해주세요.");
			member = null;
		}
		return member;
	}
	public void logout(Connection conn) {
		System.out.println("MemberDao.logout()");
	}
	public void insertMember(SqlSession sqlSession, Member member) throws SQLException {
		System.out.println("MemberDao.insertMember()");
		sqlSession.insert("com.test.mymall.dao.MemberMapper.insertMember", member);
	}
	public void deleteMember(SqlSession sqlSession, int no) {
		System.out.println("MemberDao.deleteMember()");
	}
}
