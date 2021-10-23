package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController
{

@GetMapping("/home")
public String greet()
{
	System.out.println("in home");
	return "welcome";
}

@ResponseBody
@GetMapping(value="/getStudent")
public Student getStud()
{
	Student s1=new Student(1,"Chetan","BE","P");
	return s1;
}


@ResponseBody
@GetMapping(value="/getAll",produces =MediaType.APPLICATION_JSON_VALUE)
public List<Student> getAllStudent()
{
	ArrayList<Student> al=new ArrayList<Student>();
	al.add(new Student(1,"Chetan","BE","P"));
	al.add(new Student(2,"Siya","BE","P"));
	al.add(new Student(3,"Omkar","BE","P"));
	al.add(new Student(4,"Trisha","BE","P"));
	return al;
}




}
