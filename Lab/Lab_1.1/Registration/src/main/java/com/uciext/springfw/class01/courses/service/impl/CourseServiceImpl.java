package com.uciext.springfw.class01.courses.service.impl;

import org.apache.log4j.Logger;

import com.uciext.springfw.class01.courses.service.CourseService;
import com.uciext.springfw.class01.courses.model.Course;

public class CourseServiceImpl implements CourseService {

    public static Logger logger = Logger.getLogger(CourseServiceImpl.class.getName());

    private Course course1;
    private Course course2;
    
	public CourseServiceImpl() {
	    logger.info("In CourseServiceImpl()");
	    logger.debug("debug message");
	    logger.info("info message");
	}
	
	public Course getCourse(String courseId) {
		if ("X104".equals(courseId)) {
			return course1;
		}
		else if ("X106".equals(courseId)) {
			return course2;
		}
		return null;
	}
	
	// Property Setters (for wiring)
	public void setCourse1(Course value) {
		course1 = value;
	}

	public void setCourse2(Course value) {
		course2 = value;
	}
}
