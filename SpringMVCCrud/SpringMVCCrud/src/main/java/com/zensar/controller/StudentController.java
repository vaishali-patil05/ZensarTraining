package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zensar.model.Student;
import com.zensar.service.StudentService;

@Controller
public class StudentController {
	
@Autowired	
private StudentService studservice;

@GetMapping(value="/list")
public String viewallstudents(Model m)
{
	System.out.println("innnnn");
	List<Student> slist=studservice.getAllStudents();
	m.addAttribute("listStudent",slist);
	
	return "studentlist";
}



@PostMapping(value="/insert")
public String addstud(@ModelAttribute("stud") Student s)
{
	studservice.insertStudent(s);
	return "redirect:/list";
}


@GetMapping("/delete/{sid}")
public String deletestudent(@PathVariable("sid") int id)
{
	studservice.deleteStudent(id);
	return "redirect:/list";
	
}

@GetMapping(value="/edit/{sid}")
public String updateStud(@PathVariable int sid,Model m)
{   
	Student s1=studservice.getStudent(sid);
	System.out.println(s1);
	System.out.println("in edit "+sid );
	m.addAttribute("student",s1);
	return "AddStud";
}


@PostMapping(value="/edit/save")
public String saveStud(@ModelAttribute("stud") Student s1)
{  
	System.out.println("save :"+ s1);
     studservice.updateStudent(s1);
     return "redirect:/list";
}
}
