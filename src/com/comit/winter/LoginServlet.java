package com.comit.winter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.css.CalculatedValue;

public class LoginServlet extends HttpServlet {
	private int a;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userName = req.getParameter("name");
		String pass = req.getParameter("pass");
//		
//		PrintWriter out = resp.getWriter();
//		//URL forwarding servlet option-1
//		req.setAttribute("k", 12);
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		rd.forward(req, resp);
//		
//		//Redirection Option-2
//		resp.sendRedirect("square");
		
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		
	}
}
