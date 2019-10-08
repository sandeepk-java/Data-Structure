package com.sky.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	static Connection conn = null;
	private static String[] dept = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("url", "user", "password");
			sqlExecute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	//Suppose connection is created already and you do not need to do anything with connection
	public static void sqlExecute() throws SQLException {
		PreparedStatement ps = null;
		try {
			for (int i = 0; i < 10; i++) {
				
				StringBuffer sb = new StringBuffer();
				sb.append("UPDATE emp");
				sb.append(" set status = active");
				sb.append("WHERE empNo = ? AND DEPT = ?");
				
				ps = conn.prepareStatement(sb.toString());
				
				ps.setInt(1, i + 1);
				ps.setString(2, dept[i]);
				
				ps.executeUpdate();
			}
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			
		}finally {
			
			ps.close();
		}

	}

}
