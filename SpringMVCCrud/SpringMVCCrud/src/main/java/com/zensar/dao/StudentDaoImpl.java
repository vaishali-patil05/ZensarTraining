package com.zensar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.zensar.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	//jdbctemplate--update(query,parameters)-->insert/update/delete
	//jdbctemplate query(query,rowmapper)-->list
	//queryForObject(query,rowmapper)

	@Override
	public Student getStudent(int id) {
		Student ob=jdbctemplate.queryForObject("select * from student where sid="+id,new myRowmapper());
		
		return ob;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> slist=new ArrayList<>();
		slist=jdbctemplate.query("select * from student",new myRowmapper() );
		return slist;
	}

	@Override
	public boolean insertStudent(Student student) {
		int i = jdbctemplate.update("insert into student values(?,?,?,?)", student.getSid(), student.getStudentname(),
				student.getQualification(), student.getPlaced());
		return i > 0;
	}

	@Override
	public boolean updateStudent(Student s) {
		int i = jdbctemplate.update("update student set studentname=?,qualification=?,placed=? where sid=?",
				s.getStudentname(), s.getQualification(), s.getPlaced(), s.getSid());
		return i > 0;
	}

	@Override
	public boolean deleteStudent(int id) {
		int i = jdbctemplate.update("delete from student where sid=?", id);
		return i > 0;
	}

	//callback
	class myRowmapper implements RowMapper<Student>
	{

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student s1=new Student();
				s1.setSid(rs.getInt(1));
				s1.setStudentname(rs.getString(2));
				s1.setQualification(rs.getString(3));
				s1.setPlaced(rs.getString(4));
			
			return s1;
		}

	}//inner class

}
