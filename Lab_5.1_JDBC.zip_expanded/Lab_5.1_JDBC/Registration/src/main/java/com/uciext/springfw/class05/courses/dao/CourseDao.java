package com.uciext.springfw.class05.courses.dao;

import java.util.List;

import com.uciext.springfw.class05.courses.model.Course;
import com.uciext.springfw.class05.courses.model.Schedule;
import com.uciext.springfw.class05.courses.model.Department;

public interface CourseDao {

	public void insertCourse(Course course);
	public Course findCourseById(int courseId);
	public List<Course> findCourses();
	public List<Course> findCoursesByDepartment(Department department);

}
