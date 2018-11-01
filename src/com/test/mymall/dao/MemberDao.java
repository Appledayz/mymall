package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	ResultSet rs;
	Statement stmt;
	public Member login(Connection conn, Member member) throws Exception {
		System.out.println("MemberDao.login()");
		conn = DBHelper.getConnection();
		String sql = "SELECT * FROM member WHERE id="+member.getId()+" AND pw="+member.getPw();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			System.out.println("로그인 성공");
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setLevel(rs.getInt("level"));
			member.setNo(rs.getInt("no"));
		}else {
			//	로그인 실패시 null
			System.out.println("로그인 실패, 아이디와 비밀번호를 다시 확인해주세요.");
			member = null;
		}
		DBHelper.close(rs, stmt, null);
		return member;
	}
	public void logout(Connection conn) {
		System.out.println("MemberDao.logout()");
	}
	public void insertMember(Connection conn, Member m) throws SQLException {
		System.out.println("MemberDao.insertMember()");
		String sql = "INSERT INTO member VALUES(null,"+m.getId()+","+m.getPw()+","+m.getLevel()+")";
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		DBHelper.close(null, stmt, null);
	}
	public void deleteMember(Connection conn, int no) {
		System.out.println("MemberDao.deleteMember()");
	}
}
