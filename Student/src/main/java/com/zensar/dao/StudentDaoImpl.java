package com.zensar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zensar.configuration.DBConnect;
import com.zensar.model.Student;

public class StudentDaoImpl implements StudentDao {
	private static final String INSERT_STUDENT_SQL = "insert into student(sid,studentname,qualification,placed) values(?,?,?,?)";
	private static final String SELECT_STUDENT_BY_ID = "select * from student where sid =?";
	private static final String SELECT_ALL_STUDENTS = "select * from student";
	private static final String DELETE_STUDENT_SQL = "delete from student where sid = ?;";
	private static final String UPDATE_STUDENT_SQL = "update student set studentname = ?,qualification= ?, placed =? where sid = ?;";

	@Override
	public Student getStudent(int id) {

		Student sobj = null;
		// Step 1: Establishing a Connection
		try (Connection connection = DBConnect.getConnect();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			if (rs.next()) {
				String sname = rs.getString("studentname");
				String qual = rs.getString("qualification");
				String placed = rs.getString("placed");
				sobj = new Student(id, sname, qual, placed);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sobj;

	}

	@Override
	public List<Student> getAllStudents() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Student> slist = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = DBConnect.getConnect();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("sid");
				String name = rs.getString("studentname");
				String q = rs.getString("qualification");
				String placed = rs.getString("placed");
				Student s = new Student(id, name, q, placed);
				slist.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public boolean insertStudent(Student stud) {
		try (Connection con = DBConnect.getConnect();
				PreparedStatement pst = con.prepareStatement(INSERT_STUDENT_SQL)) {
			pst.setInt(1, stud.getSid());
			pst.setString(2, stud.getStudentname());
			pst.setString(3, stud.getQualification());
			pst.setString(4, stud.getPlaced());
			pst.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		try (Connection connection = DBConnect.getConnect();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL);) {
			statement.setString(1, s.getStudentname());
			statement.setString(2, s.getQualification());
			statement.setString(3, s.getPlaced());
			statement.setInt(4, s.getSid());

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		try (Connection connection = DBConnect.getConnect();
			PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);) {
			statement.setInt(1, id);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
