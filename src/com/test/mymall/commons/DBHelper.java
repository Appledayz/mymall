package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBHelper {
	public static Connection getConnection() throws Exception {
		System.out.println("DBHelper.getConnection()");
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mymall");
		Connection conn = ds.getConnection();
		return conn;
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		System.out.println("DBHelper.close()");
        if(rs != null) {try {rs.close();} catch(Exception e) {e.printStackTrace();}}
        if(stmt != null) {try {stmt.close();} catch(Exception e) {e.printStackTrace();}}
        if(conn != null) {try {conn.close();} catch(Exception e) {e.printStackTrace();}}
	}
}
