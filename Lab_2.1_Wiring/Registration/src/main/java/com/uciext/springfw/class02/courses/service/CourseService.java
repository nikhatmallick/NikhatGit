package com.uciext.springfw.class02.courses.service;

import java.util.List;
import java.util.Map;

import com.uciext.springfw.class02.courses.model.Course;

public interface CourseService {
	public Course getCourse(String courseId);
	public Map<String, Course> getCourses();
}
