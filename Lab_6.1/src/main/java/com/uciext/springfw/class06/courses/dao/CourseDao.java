package com.uciext.springfw.class06.courses.dao;

import java.util.List;

import com.uciext.springfw.class06.courses.model.Course;
import com.uciext.springfw.class06.courses.model.Department;
import com.uciext.springfw.class06.courses.model.Schedule;

public interface CourseDao {

	public void insertCourse(Course course);
	public Course findCourseById(int courseId);
	public List<Course> findCourses();
	public List<Course> findCoursesByDepartment(Department department);

}
