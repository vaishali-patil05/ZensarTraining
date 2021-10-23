package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dao.StudentDao;
import com.zensar.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao sdao;
	
	
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
