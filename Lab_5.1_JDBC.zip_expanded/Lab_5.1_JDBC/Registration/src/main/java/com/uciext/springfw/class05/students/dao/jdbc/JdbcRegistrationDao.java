package com.uciext.springfw.class05.students.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.uciext.springfw.class05.common.Util;
import com.uciext.springfw.class05.courses.model.Schedule;
import com.uciext.springfw.class05.courses.service.CourseService;
import com.uciext.springfw.class05.students.dao.RegistrationDao;
import com.uciext.springfw.class05.students.model.Registration;
import com.uciext.springfw.class05.students.model.Student;
import com.uciext.springfw.class05.students.service.StudentService;

public class JdbcRegistrationDao implements RegistrationDao {

    protected static Logger logger = Logger.getLogger(JdbcRegistrationDao.class.getName());

	// SQL statements
	private static final String SQL_INSERT_REGISTRATION = 
			"INSERT INTO registrations (registration_id, student_id, schedule_id, reg_date) "
			+ " VALUES (?, ?, ?, ?)";
	private static final String SQL_FIND_REGISTRATION_BY_ID = 
			"SELECT * FROM registrations WHERE registration_id = ?";
	private static final String SQL_FIND_REGISTRATIONS = 
			"SELECT * FROM registrations";
	private static final String SQL_FIND_REGISTRATIONS_BY_STUDENT = 
			"SELECT * FROM registrations WHERE student_id = ?";
	private static final String SQL_FIND_REGISTRATIONS_BY_SCHEDULE = 
			"SELECT * FROM registrations WHERE schedule_id = ?";
	
	// Datastore Template
	private JdbcTemplate jdbcTemplate; 

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { 
		this.jdbcTemplate = jdbcTemplate; 
	} 

	// Services used forgetting other objects
	private CourseService courseService; 
	public void setCourseService(CourseService courseService) { 
		this.courseService = courseService; 
	} 

	private StudentService studentService; 
	public void setStudentService(StudentService studentService) { 
		this.studentService = studentService; 
	} 

	//=================================================
	// DB methods

	@Override
	public void insertRegistration(Registration registration) {
		registration.setRegistrationId(Util.getRandomInt());
		jdbcTemplate.update(SQL_INSERT_REGISTRATION, 
				registration.getRegistrationId(), 
				registration.getStudent().getStudentId(),
				registration.getSchedule().getScheduleId(),
				registration.getRegistrationDate());
	}
	
	@Override
	public Registration findRegistrationById(int registrationId) {
		Registration registration = (Registration)jdbcTemplate.queryForObject(
				SQL_FIND_REGISTRATION_BY_ID, new RegistrationRowMapper(), 
				new Object[] { registrationId });
		return registration;
	}
	
	@Override
	public List<Registration> findRegistrations() {
		List<Registration> registrations = new ArrayList<Registration>();
	      
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_REGISTRATIONS);
		for (Map row : rows) {
			Registration registration = new Registration(
				Integer.parseInt(String.valueOf(row.get("registration_id"))),
				studentService.getStudent(Integer.parseInt(String.valueOf(row.get("student_id")))),
				courseService.getSchedule(Integer.parseInt(String.valueOf(row.get("schedule_id")))),
				null // TBD Date
				);
			registrations.add(registration);
		}
		return registrations;
	}
	
	@Override
	public List<Registration> findRegistrationsByStudent(Student student) {
		List<Registration> registrations = new ArrayList<Registration>();
	      
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_REGISTRATIONS_BY_STUDENT,
				new Object[] { student.getStudentId() });
		
		for (Map row : rows) {
			Registration registration = new Registration(
				Integer.parseInt(String.valueOf(row.get("registration_id"))),
				student,
				courseService.getSchedule(Integer.parseInt(String.valueOf(row.get("schedule_id")))),
				null // TBD Date
				);
			System.out.println("regDate=" + row.get("reg_date"));
			registrations.add(registration);
		}
		return registrations;
	}
	
	@Override
	public List<Registration> findRegistrationsBySchedule(Schedule schedule) {
		List<Registration> registrations = new ArrayList<Registration>();
	      
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_REGISTRATIONS_BY_SCHEDULE,
				new Object[] { schedule.getScheduleId() });
				
		for (Map row : rows) {
			Registration registration = new Registration(
				Integer.parseInt(String.valueOf(row.get("registration_id"))),
				studentService.getStudent(Integer.parseInt(String.valueOf(row.get("student_id")))),
				schedule,
				null // TBD Date
				);
			registrations.add(registration);
		}
		return registrations;
	}

	private class RegistrationRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Registration registration = new Registration (
				rs.getInt("registration_id"),
				studentService.getStudent(rs.getInt("student_id")),
				courseService.getSchedule(rs.getInt("schedule_id")),
				new Date(rs.getTimestamp("created").getTime())
			);
			return registration;
		}
	}


}
