package com.zensar.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.Model.Student;



//@GetMapping
//@RequestMapping
//@ResponseBody
//@RequestParam
//@ModelAttribute
//@pathvariable
//@ExceptionHandler


@Controller
public class StudentController {
	
	
	@ResponseBody
	@GetMapping(value="/home")
	public String deepa() {
		System.out.println("HomeController: Passing through...");
		return "welcome user rgdg gfdg fgdf"; //view
	} 
	
	//@RequestMapping(value="/add",method=RequestMethod.POST)
	
	@PostMapping(value="/add")
	public String addStudent(@RequestParam("t1") String nm,@RequestParam("t2") String p ,Model m)
	{
		m.addAttribute("user", nm);
		m.addAttribute("pass",p);
		return "studview";
		
	}

	@PostMapping(value="/addd")
	public ModelAndView insertStudent(@RequestParam("t1") String nm,@RequestParam("t2") String p ,Model m)
	{
		
		ModelAndView mv=new ModelAndView("studview");
		mv.addObject("user",nm);
		mv.addObject("pass",p);
		return mv;
		
	}
	@RequestMapping("/")
	public String start()
	{
	return "AddStud";	
	}
	
	
	@PostMapping("/insertt")
	public ModelAndView insertStudent(@RequestParam Map<String,String> map)
	{
		System.out.println(map);
		Student s1=new Student();
		s1.setSid(Integer.parseInt(map.get("sid")));
		s1.setSname(map.get("sname"));
		s1.setQualification(map.get("qualification"));
		s1.setPlaced(map.get("placed"));
		ModelAndView mv=new ModelAndView("studlist");
		mv.addObject("stud",s1);
		return mv;
		
	}
	
	@PostMapping("/insert")
	public ModelAndView insertStudent(@ModelAttribute("stud") Student s1)
	{
		System.out.println("in modelattribute");
		ModelAndView mv=new ModelAndView("studlist");
		return mv;
	}
	
	@ResponseBody
	@GetMapping("/deletestud/{sid}")
    public void deleteStud(@PathVariable int sid )
    {
    System.out.println("id ddc" +sid);
    
    }
	
	@ExceptionHandler(value=NumberFormatException.class)
	public String errorhandler(Exception e)
	{
		return "error";
	}
}
