package com.tqpp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/demo1")
public class DemoServlet extends HttpServlet {
	
	
	public DemoServlet() {
		System.out.println("hi in default cons of serv1");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String method=request.getMethod();
		String username=request.getParameter("fname");
		String passwd=request.getParameter("pass");
		
		if(username.equals("admin") && passwd.equals("123"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("riya");
			rd.forward(request, response);
		}
		else
		{
			out.println("Wrong username and password");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
		
	}

	
}
