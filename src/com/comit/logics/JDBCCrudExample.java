package com.comit.logics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
 
public class JDBCCrudExample {
    
    public static void main(String[] args) throws SQLException {
 
        String url ="jdbc:mysql://localhost:3306/khanscafe?serverTimezone=UTC"; //update connection string
        
        String user = "user";//add your db user id here
        String password = "password";//add your db password here
        
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Successfully connected");
        
        //insert employee record into database
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate("insert into employee(age,name) values(23,'James')");
        System.out.println("Rows inserted = "+ rows);
        
        //update employee record
        rows= stmt.executeUpdate("Update employee set age=31 where name='James'");
        System.out.println("Rows updated = "+ rows);
        
        //read employee records
        ResultSet rs = stmt.executeQuery("Select * from employee");
        while(rs.next()){
            System.out.println("Emp Id : " + rs.getInt("id") + ", Name : " + rs.getString("name") + ", Age : " + rs.getInt("age"));
        }
        
        //delete employee record
        rows = stmt.executeUpdate("delete from employee where name = 'James'");
        System.out.println("Rows deleted = "+ rows);
    }
    
 
}