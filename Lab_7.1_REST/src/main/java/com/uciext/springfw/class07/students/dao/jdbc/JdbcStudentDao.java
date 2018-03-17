package com.uciext.springfw.class07.students.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.uciext.springfw.class07.common.Util;
import com.uciext.springfw.class07.students.dao.StudentDao;
import com.uciext.springfw.class07.students.model.Student;

public class JdbcStudentDao implements StudentDao {

    protected static Logger logger = Logger.getLogger(JdbcStudentDao.class.getName());

	// SQL statements
	private static final String SQL_INSERT_STUDENT = 
			"INSERT INTO students (student_id, student_name) VALUES (?, ?)";
	private static final String SQL_FIND_STUDENTS = 
			"SELECT * FROM students";
	private static final String SQL_FIND_STUDENT_BY_ID = 
			"SELECT * FROM students WHERE student_id = ?";

	// Datastore Template
	private JdbcTemplate jdbcTemplate; 

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { 
		this.jdbcTemplate = jdbcTemplate; 
	} 

	//=================================================
	// DB methods

	@Override
	public void insertStudent(Student student) {
		student.setStudentId(Util.getRandomInt());
		jdbcTemplate.update(SQL_INSERT_STUDENT, 
				student.getStudentId(), student.getStudentName());
	}
	
	@Override
	public List<Student> findStudents() {
		List<Student> students = new ArrayList<Student>();
	      
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_STUDENTS);
		for (Map row : rows) {
			Student student = new Student(
				Integer.parseInt(String.valueOf(row.get("student_id"))),
				(String)row.get("student_name")
			);
			students.add(student);
		}

		return students;
	}
	
	@Override
	public Student findStudentById(int studentId) {
		Student student = (Student)jdbcTemplate.queryForObject(
				SQL_FIND_STUDENT_BY_ID, new StudentRowMapper(), new Object[] { studentId });
		return student;
	}

	private class StudentRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student(
				rs.getInt("student_id"),
				rs.getString("student_name")
			);
			return student;
		}
	}
	
}
