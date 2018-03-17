package com.uciext.springfw.class05.courses.model;

import java.lang.StringBuilder;
import java.util.Date;

import org.apache.log4j.Logger;

public class Course {

    protected static Logger logger = Logger.getLogger(Course.class.getName());

	// Properties
    private int courseId;
    private String courseCode;
    private String courseName;
    private Date createDate;
    private Department department;

    // Constructors
    public Course() {
	}

    public Course(int courseId, String courseCode, String courseName, 
    		Date createDate, Department department) {
	   this.courseId = courseId;
	   this.courseCode = courseCode;
	   this.courseName = courseName;
	   this.createDate = createDate;
	   this.department = department;
	}

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int value) {
        this.courseId = value;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String value) {
        this.courseName = value;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String value) {
        this.courseCode = value;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date value) {
        this.createDate = value;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department value) {
        this.department = value;
    }

    public String toString() {
    	StringBuilder buff = new StringBuilder("[Course: ")
       .append("courseId=").append(getCourseId())
       .append(", courseCode=").append(getCourseCode())
       .append(", courseName=").append(getCourseName())
       .append(", createDate=").append(getCreateDate())
       .append(", department=").append(getDepartment())
       .append("]")
       ;

       return buff.toString();
    }
}
