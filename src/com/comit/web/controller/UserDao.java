package com.comit.web.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comit.web.entity.User;

public class UserDao {

	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getUserByUserName(String userName) {
		String url = "jdbc:mysql://localhost:3306/khanscafe?serverTimezone=UTC";
		String username = "root";
		String pass = "R@sel123";
		String query = "Select * from users where userName="+userName;
		
		User userObj = new User();
		
		try {
			Connection conn = DriverManager.getConnection(url, username, pass);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				userObj.setId(rs.getInt("id"));
				userObj.setFirstName(rs.getString("firstName"));
				userObj.setLastName(rs.getString("lastName"));
				userObj.setUserName(rs.getString("userName"));
				userObj.setPassword(rs.getString("password"));
				userObj.setEmail(rs.getString("email"));
			}
			rs.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userObj;
	}
	

	public boolean validateLogin(String userName, String password) {
		User user = this.getUserByUserName(userName);
		if(user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}


}
