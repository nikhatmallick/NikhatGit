package com.uciext.springfw.class03.courses.service;

import java.util.Map;

import com.uciext.springfw.class03.courses.model.Course;

public interface CourseService {
	public Course getCourse(String courseId);
	public Map<String, Course> getCourses();
}
