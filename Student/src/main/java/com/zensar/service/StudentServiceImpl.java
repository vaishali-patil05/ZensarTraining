package com.zensar.service;

import java.util.List;

import com.zensar.dao.StudentDao;
import com.zensar.dao.StudentDaoImpl;
import com.zensar.model.Student;

public class StudentServiceImpl implements StudentService {

	StudentDao sdao;
	public StudentServiceImpl() {
		sdao=new StudentDaoImpl();
	}
	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return sdao.getStudent(id);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return sdao.getAllStudents();
	}

	@Override
	public boolean insertStudent(Student student) {
		// TODO Auto-generated method stub
		return sdao.insertStudent(student);
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		return sdao.updateStudent(s);
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return sdao.deleteStudent(id);
	}

}
