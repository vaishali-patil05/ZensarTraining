package com.zensar.controller;

import java.io.IOException;
import java.util.List;

import com.zensar.model.Student;
import com.zensar.service.StudentServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class StudentController extends HttpServlet 
{
static final long serialVersionUID = 1L;

private StudentServiceImpl studservice;
	
	public StudentController() {
		studservice=new StudentServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		System.out.println(action);
		switch(action)
		{
		default:       List<Student> listStudent = studservice.getAllStudents();
						request.setAttribute("listStudent", listStudent);
						RequestDispatcher dispatcher = request.getRequestDispatcher("studentlist.jsp");
						dispatcher.forward(request, response);
						break;
		case "/edit":  int sid=Integer.parseInt(request.getParameter("id"));
		               Student sobj=studservice.getStudent(sid); 
		               //System.out.println(sobj);
		               request.setAttribute("student", sobj);
		               dispatcher = request.getRequestDispatcher("AddStud.jsp");
					   dispatcher.forward(request, response);
						break;
		case "/save":  int id=Integer.parseInt(request.getParameter("sid"));
						String nm=request.getParameter("snm");
						String q=request.getParameter("q");
						String p=request.getParameter("placed");
						Student s1=new Student(id, nm, q, p);
						studservice.updateStudent(s1);
						response.sendRedirect("list");
						break;
		case "/add":     System.out.println("in add");
						System.out.println("sid"+request.getParameter("sid"));
						id=Integer.parseInt(request.getParameter("sid"));
						 nm=request.getParameter("snm");
						 q=request.getParameter("q");
						 p=request.getParameter("placed");
						 s1=new Student(id, nm, q, p);
						studservice.insertStudent(s1);
						response.sendRedirect("list");
						break;
		}
	}

	
}
