package com.comit.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.comit.web.entity.User;

public class UserDao {
	private String dbUrl="";
	private String dbUserName="";
	private String dbPassword="";
	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setDbCredentials(String dbUrl, String dbUserName, String dbPassword) {
		this.dbUrl = dbUrl;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
	}
	public User getUserByUserName(String userName) {
		

		String query = "SELECT * FROM users";

		User userObj = new User();

		try {
			Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("userName") + " " + userName);
				if (rs.getString("userName").equals(userName)) {
					System.out.println("We are heree");
					userObj.setId(rs.getInt("id"));
					userObj.setFirstName(rs.getString("firstName"));
					userObj.setLastName(rs.getString("lastName"));
					userObj.setUserName(rs.getString("userName"));
					userObj.setPassword(rs.getString("password"));
					userObj.setEmail(rs.getString("email"));
				}
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
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
