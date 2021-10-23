package com.zensar.dao;

import java.util.List;

import com.zensar.model.Student;

public interface StudentDao {

Student getStudent(int id);
List<Student> getAllStudents();
boolean insertStudent(Student student);
boolean updateStudent(Student s);
boolean deleteStudent(int id);

}
