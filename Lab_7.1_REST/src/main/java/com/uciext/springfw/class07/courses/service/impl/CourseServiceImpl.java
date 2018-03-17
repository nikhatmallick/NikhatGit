package com.uciext.springfw.class07.courses.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.uciext.springfw.class07.courses.dao.CourseDao;
import com.uciext.springfw.class07.courses.dao.DepartmentDao;
import com.uciext.springfw.class07.courses.dao.ScheduleDao;
import com.uciext.springfw.class07.courses.model.Course;
import com.uciext.springfw.class07.courses.model.Department;
import com.uciext.springfw.class07.courses.model.Schedule;
import com.uciext.springfw.class07.courses.service.CourseService;

public class CourseServiceImpl implements CourseService {

    private static Logger logger = Logger.getLogger(CourseServiceImpl.class.getName());

    // DAO classes
    private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

    private CourseDao courseDao;
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

    private ScheduleDao scheduleDao;
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

    //----------------------------------------------
	// Departments
	
    @Override
	public Department getDepartment(int departmentId) {
		System.out.println("--- getDepartment() departmentId=" + departmentId);
		return departmentDao.findDepartmentById(departmentId);
	}
	
    @Override
	public List<Department> getDepartments() {
		System.out.println("--- getDepartments()");
		return departmentDao.findDepartments();
	}
	
    @Override
	public void insertDepartment(Department department) {
		System.out.println("--- insertDepartment() department=" + department);
		departmentDao.insertDepartment(department);
	}
	
    @Override
	public void updateDepartment(int departmentId, Department department) {
		System.out.println("--- updateDepartment() departmentId=" + departmentId + ", department=" + department);
		departmentDao.updateDepartment(departmentId, department);
	}
	

    @Override
    public void deleteDepartment(int departmentId) {
		System.out.println("--- deleteDepartment() departmentId=" + departmentId);
		departmentDao.deleteDepartment(departmentId);
	}
    
    //----------------------------------------------
    // Courses
    
    @Override
	public Course getCourse(int courseId) {
		System.out.println("--- getCourse() courseId=" + courseId);
		return courseDao.findCourseById(courseId);
	}

    @Override
	public void insertCourse(Course course) {
		System.out.println("--- insertCourse() course=" + course);
		courseDao.insertCourse(course);
	}
	
    @Override
	public List<Course> getCourses() {
		System.out.println("--- getCourses");
		return courseDao.findCourses();
	}

    @Override
	public List<Course> getCoursesByDepartment(Department department) {
		System.out.println("--- getCoursesByDepartment() department=" + department);
		return courseDao.findCoursesByDepartment(department);
	}

    //----------------------------------------------
    // Schedules
    
    @Override
	public Schedule getSchedule(int scheduleId) {
		System.out.println("--- getSchedule() scheduleId=" + scheduleId);
		return scheduleDao.findScheduleById(scheduleId);
	}

    @Override
	public void insertSchedule(Schedule schedule) {
		System.out.println("--- insertSchedule() schedule=" + schedule);
		scheduleDao.insertSchedule(schedule);
	}

    @Override
	public List<Schedule> getSchedules() {
		System.out.println("--- getSchedules");
		return scheduleDao.findSchedules();
	}

    @Override
	public List<Schedule> getSchedulesByCourse(Course course) {
		System.out.println("--- getSchedulesByCourse");
		return scheduleDao.findSchedulesByCourse(course);
	}


}
