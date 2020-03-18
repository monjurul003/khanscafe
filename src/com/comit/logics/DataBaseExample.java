package com.comit.logics;

import java.sql.*;

import com.mysql.*;

public class DataBaseExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/khanscafe?serverTimezone=UTC";
		String username = "root";
		String pass = "R@sel123";
		String query = "Select * from users where userName=jane_doe";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, pass);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.print(rs.getString("firstName") +","+ rs.getString("lastName")+",");
			System.out.println(rs.getString("userName"));
		}
		rs.close();
		conn.close();
	}
}
