package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

public class DBHelper {
	public static Connection getConnection() throws Exception {
		Context init = new InitialContext();
		Connection conn = (Connection) init.lookup("java:comp/env/jdbc/mymall");
		return conn;
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if(rs != null) {try {rs.close();} catch(Exception e) {e.printStackTrace();}}
        if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
        if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	}
}
