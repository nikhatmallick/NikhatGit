package com.uciext.springfw.class04.courses.model;

import java.lang.StringBuilder;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;

import com.uciext.springfw.class04.courses.events.DepartmentUpdatedEvent;

public abstract class Course {

    protected static Logger logger = Logger.getLogger(Course.class.getName());

	// Properties
    private String courseId;
    private String courseName;

    private Integer maxNameLength;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Locale locale;
    
    // Constructors
    public Course() {
	}

    public Course(String courseId, String courseName) {
	   this.courseId = courseId;
	   this.courseName = courseName;
	}

    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String value) {
        this.courseId = value;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String value) {
        this.courseName = value;
    }

    public abstract Department getDepartment();

	public Integer getMaxNameLength() {
		return maxNameLength;
	}
	public void setMaxNameLength(Integer maxNameLength) {
		this.maxNameLength = maxNameLength;
	}
	
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

    public String toString() {
        if (courseName.length() > maxNameLength) {
			logger.warn(messageSource.getMessage("err.course.name.maxLength", 
					new Object [] { courseName }, 
					locale));
        }

    	StringBuilder buff = new StringBuilder("[Course: ")
       .append("courseId=").append(getCourseId())
       .append(", courseName=").append(getCourseName())
       .append(", department=").append(getDepartment())
       .append("]")
       ;

       return buff.toString();
    }
}
