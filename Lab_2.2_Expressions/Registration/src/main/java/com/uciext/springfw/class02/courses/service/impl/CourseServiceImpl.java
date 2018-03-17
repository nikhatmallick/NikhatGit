package com.uciext.springfw.class02.courses.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import com.uciext.springfw.class02.courses.model.Course;
import com.uciext.springfw.class02.courses.service.CourseService;

public class CourseServiceImpl implements CourseService {

    private static Logger logger = Logger.getLogger(CourseServiceImpl.class.getName());

    private Map<String, Course> courseMap;
    
	public CourseServiceImpl() {
	}
	
	public Course getCourse(String courseId) {
		return courseMap.get(courseId);
	}
	
	// Property Setters (for wiring)
	public void setCourses(Map<String, Course> value) {
		courseMap = value;
	}

	public Map<String, Course> getCourses() {
		return courseMap;
	}
	
}
