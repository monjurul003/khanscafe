package com.comit.winter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comit.web.controller.UserDao;

public class LoginServlet extends HttpServlet {
	private int a;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userName = req.getParameter("name");
		String pass = req.getParameter("pass");
		UserDao obj = new UserDao();
		
		System.out.println("asdasdasd");
		
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
}
