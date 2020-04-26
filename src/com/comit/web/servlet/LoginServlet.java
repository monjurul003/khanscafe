package com.comit.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comit.web.controller.UserDao;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private int a;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userName = req.getParameter("name");
		String pass = req.getParameter("pass");
		UserDao obj = new UserDao();
		
		loadDbCredential(obj);
		
		System.out.println(userName + " "+ pass);
		
		if(obj.validateLogin(userName, pass)) {
			RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
			rd.forward(req, resp);
			
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(req, resp);
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>asdasd</h1>");
		
	}
	private void loadDbCredential(UserDao obj){
		String webAppPath = getServletContext().getRealPath("/");
		 
		try (InputStream input = new FileInputStream(webAppPath + File.separator + "config.properties")) {

            Properties prop = new Properties();
            
            // load a properties file
            prop.load(input);
            obj.setDbCredentials(prop.getProperty("db.url"), prop.getProperty("db.user"), prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
