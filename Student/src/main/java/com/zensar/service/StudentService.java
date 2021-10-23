package com.zensar.service;

import java.util.List;

import com.zensar.model.Student;

public interface StudentService 
{
	Student getStudent(int id);
    List<Student> getAllStudents();
    boolean insertStudent(Student student);
    boolean updateStudent(Student s);
    boolean deleteStudent(int id);

}
