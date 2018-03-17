package com.uciext.springfw.class05.courses.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.uciext.springfw.class05.common.Util;
import com.uciext.springfw.class05.courses.dao.ScheduleDao;
import com.uciext.springfw.class05.courses.model.Course;
import com.uciext.springfw.class05.courses.model.Department;
import com.uciext.springfw.class05.courses.model.Schedule;
import com.uciext.springfw.class05.courses.service.CourseService;

public class JdbcScheduleDao implements ScheduleDao {

	protected static Logger logger = Logger.getLogger(JdbcScheduleDao.class.getName());

	// SQL statements
	private static final String SQL_INSERT_SCHEDULE = 
			"INSERT INTO schedules (schedule_id, course_id, year, quarter, instructor)"
			+ " VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_FIND_SCHEDULE_BY_ID = 
			"SELECT * FROM schedules WHERE schedule_id = ?";
	private static final String SQL_FIND_SCHEDULES = 
			"SELECT * FROM schedules";
	private static final String SQL_FIND_SCHEDULES_BY_COURSE = 
			"SELECT * FROM schedules WHERE course_id = ?";
/*
 	// Optimization
	private static final String SQL_FIND_SCHEDULES_BY_COURSE_2 = 
			"SELECT * FROM schedules s, courses c, departments d "
			+ " WHERE s.course_id = ?"
			+ " AND s.course_id = c.course_id"
			+ " AND c.department_id = d.department_id"
			;
*/	
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
	public void insertSchedule(Schedule schedule) {
		logger.info("In insertSchedule schedule=" + schedule);
		Connection conn = null;
 
		try {
			schedule.setScheduleId(Util.getRandomInt());

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT_SCHEDULE);
			ps.setInt(1, schedule.getScheduleId());
			ps.setInt(2, schedule.getCourse().getCourseId());
			ps.setInt(3, schedule.getYear());
			ps.setInt(4, schedule.getQuarter());
			ps.setString(5, schedule.getInstructor());
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
	public Schedule findScheduleById(int scheduleId) {
		logger.info("In findScheduleById scheduleId=" + scheduleId);
		Connection conn = null;
		Schedule schedule = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_SCHEDULE_BY_ID);
			ps.setInt(1, scheduleId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				schedule = new Schedule(
					rs.getInt("schedule_id"),
					courseService.getCourse(rs.getInt("course_id")),
					rs.getInt("year"),
					rs.getInt("quarter"),
					rs.getString("instructor")
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
		logger.info("exit findByScheduleId schedule=" + schedule);
		return schedule;
	}

	@Override
	public List<Schedule> findSchedules() {
		logger.info("In findSchedules");
		Connection conn = null;
		List<Schedule> schedules = new ArrayList<Schedule>();
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_SCHEDULES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Schedule schedule = new Schedule(
					rs.getInt("schedule_id"),
					courseService.getCourse(rs.getInt("course_id")),
					rs.getInt("year"),
					rs.getInt("quarter"),
					rs.getString("instructor")
				);
				schedules.add(schedule);
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
		logger.info("exit findSchedules");
		return schedules;
	}

	@Override
	public List<Schedule> findSchedulesByCourse(Course course) {
		logger.info("In findSchedulesByCourse course=" + course);
		Connection conn = null;
		List<Schedule> schedules = new ArrayList<Schedule>();
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_SCHEDULES_BY_COURSE);
			ps.setInt(1, course.getCourseId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Schedule schedule = new Schedule(
					rs.getInt("schedule_id"),
					courseService.getCourse(rs.getInt("course_id")),
					rs.getInt("year"),
					rs.getInt("quarter"),
					rs.getString("instructor")
				);
				schedules.add(schedule);
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
		logger.info("exit findSchedulesByCourse");
		return schedules;
	}

/*
 	// Optimization

	@Override
	public List<Schedule> findSchedulesByCourse(Course course) {
		logger.info("In findSchedulesByCourse course=" + course);
		Connection conn = null;
		List<Schedule> schedules = new ArrayList<Schedule>();
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_SCHEDULES_BY_COURSE_2);
			ps.setInt(1, course.getCourseId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Department department2 = new Department(
					rs.getInt("department_id"),
					rs.getString("department_name")
				);

				Course course2 = new Course(
					rs.getInt("course_id"),
					rs.getString("course_code"),
					rs.getString("course_name"),
					new Date(rs.getTimestamp("created").getTime()),
					department2);

				Schedule schedule = new Schedule(
					rs.getInt("schedule_id"),
					course2,
					rs.getInt("year"),
					rs.getInt("quarter"),
					rs.getString("instructor")
				);
				schedules.add(schedule);
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
		logger.info("exit findSchedulesByCourse");
		return schedules;
	}
*/
}
