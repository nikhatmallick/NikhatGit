package com.uciext.springfw.class03.courses.model;

import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public abstract class Course {

    protected static Logger logger = Logger.getLogger(Course.class.getName());

	// Properties
    private String courseId;
    private String courseName;

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

    public String toString() {
       StringBuilder buff = new StringBuilder("[Course: ")
       .append("courseId=").append(getCourseId())
       .append(", courseName=").append(getCourseName())
       .append(", department=").append(getDepartment())
       .append("]")
       ;

       return buff.toString();
    }

}
