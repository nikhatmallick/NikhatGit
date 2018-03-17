package com.uciext.springfw.class06.courses.service;

import java.util.List;

import com.uciext.springfw.class06.courses.model.Course;
import com.uciext.springfw.class06.courses.model.Department;
import com.uciext.springfw.class06.courses.model.Schedule;

public interface CourseService {

	// Departments
	public Department getDepartment(int departmentId);
	public List<Department> getDepartments();
	public void insertDepartment(Department department);

	// Courses
	public Course getCourse(int courseId);
	public void insertCourse(Course course);
	public List<Course> getCourses();
	public List<Course> getCoursesByDepartment(Department department);
	
	// Schedules
	public Schedule getSchedule(int scheduleId);
	public void insertSchedule(Schedule schedule);
	public List<Schedule> getSchedules();
	public List<Schedule> getSchedulesByCourse(Course course);

}
