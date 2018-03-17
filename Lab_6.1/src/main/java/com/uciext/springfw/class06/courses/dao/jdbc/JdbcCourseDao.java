package com.uciext.springfw.class06.courses.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.uciext.springfw.class06.common.Util;
import com.uciext.springfw.class06.courses.dao.CourseDao;
import com.uciext.springfw.class06.courses.model.Course;
import com.uciext.springfw.class06.courses.model.Department;
import com.uciext.springfw.class06.courses.model.Schedule;
import com.uciext.springfw.class06.courses.service.CourseService;

public class JdbcCourseDao implements CourseDao {
	
    protected static Logger logger = Logger.getLogger(JdbcCourseDao.class.getName());

	// SQL statements
	private static final String SQL_INSERT_COURSE = 
			"INSERT INTO courses (course_id, department_id, course_code, course_name) "
			+ " VALUES (?, ?, ?, ?)";
	private static final String SQL_FIND_COURSE_BY_ID = 
			"SELECT * FROM courses WHERE course_id = ?";
	private static final String SQL_FIND_COURSES = 
			"SELECT * FROM courses";
	private static final String SQL_FIND_COURSES_BY_DEPARTMENT_ID = 
			"SELECT * FROM courses WHERE department_id = ?";

	// Datasource
	private DataSource dataSource;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	// Course service
	private CourseService courseService;
	 
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
 
	//=================================================
	// DB methods

	@Override
	public void insertCourse(Course course) {
		logger.info("In insertCourse course=" + course);
		Connection conn = null;
 
		try {
			course.setCourseId(Util.getRandomInt());

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_COURSE);
			ps.setInt(1, course.getCourseId());
			ps.setInt(2, course.getDepartment().getDepartmentId());
			ps.setString(3, course.getCourseCode());
			ps.setString(4, course.getCourseName());
			ps.executeUpdate();
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}	

	@Override
	public Course findCourseById(int courseId) {
		logger.info("In findCourseById courseId=" + courseId);
		Connection conn = null;
		Course course = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_COURSE_BY_ID);
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				course = new Course(
					rs.getInt("course_id"),
					rs.getString("course_code"),
					rs.getString("course_name"),
					new Date(rs.getTimestamp("created").getTime()),
					courseService.getDepartment(rs.getInt("department_id"))
				);
			}
			rs.close();
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		logger.info("exit findByCourseId course=" + course);
		return course;
	}

	@Override
	public List<Course> findCourses() {
		logger.info("In findCourses");
		Connection conn = null;
		List<Course> courses = new ArrayList<Course>();
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_COURSES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				courses.add(new Course(
					rs.getInt("course_id"),
					rs.getString("course_code"),
					rs.getString("course_name"),
					new Date(rs.getTimestamp("created").getTime()),
					courseService.getDepartment(rs.getInt("department_id"))
				));
			}
			rs.close();
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		logger.info("exit findCourses courses.size=" + (courses != null?courses.size():0));
		return courses;
	}

	@Override
	public List<Course> findCoursesByDepartment(Department department) {
		logger.info("In findCoursesByDepartment department=" + department);
		Connection conn = null;
		List<Course> courses = new ArrayList<Course>();
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_COURSES_BY_DEPARTMENT_ID);
			ps.setInt(1, department.getDepartmentId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				courses.add(new Course(
					rs.getInt("course_id"),
					rs.getString("course_code"),
					rs.getString("course_name"),
					new Date(rs.getTimestamp("created").getTime()),
					courseService.getDepartment(rs.getInt("department_id"))
				));
			}
			rs.close();
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		logger.info("exit findCoursesByDepartmentId courses.size=" + (courses != null?courses.size():0));
		return courses;
	}

}
