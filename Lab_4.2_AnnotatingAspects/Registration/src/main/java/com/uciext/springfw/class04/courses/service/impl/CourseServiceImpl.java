package com.uciext.springfw.class04.courses.service.impl;

import java.util.Map;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.uciext.springfw.class04.common.Util;
import com.uciext.springfw.class04.courses.events.DepartmentUpdatedEvent;
import com.uciext.springfw.class04.courses.model.Course;
import com.uciext.springfw.class04.courses.model.Department;
import com.uciext.springfw.class04.courses.service.CourseService;

public class CourseServiceImpl implements CourseService, 
		ApplicationListener<DepartmentUpdatedEvent> {

    private static Logger logger = Logger.getLogger(CourseServiceImpl.class.getName());

    private Map<String, Course> courseMap;
    private Integer maxCourses;
    
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Locale locale;

	public CourseServiceImpl() {
	}

	public void setMaxCourses(Integer maxCourses) {
		this.maxCourses = maxCourses;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public Course getCourse(String courseId) {
		System.out.println("--- In CourseServiceImpl.getCourse()");
		return courseMap.get(courseId);
	}
	
	// Property Setters (for wiring)
	public void setCourses(Map<String, Course> value) {
		courseMap = value;
	}

	public Map<String, Course> getCourses() {
		System.out.println("--- In CourseServiceImpl.getCourses()");
		if (courseMap.size() > maxCourses) {
			logger.error(messageSource.getMessage("err.courses.maxCount", 
					new Object [] { courseMap.size() }, 
					locale));
		}
		return (Map<String, Course>)courseMap;
	}

    @Override
    public void onApplicationEvent(DepartmentUpdatedEvent event) {
		Department department = (Department)event.getEventData();
       	for (Course course : courseMap.values()) {
       		if (course.getDepartment().getDeptName().equalsIgnoreCase(department.getDeptName())) {
       			course.setCourseId(department.getDeptName().substring(0, 1)
       					+ course.getCourseId().substring(1));
       		}
       	}
    }     
}
