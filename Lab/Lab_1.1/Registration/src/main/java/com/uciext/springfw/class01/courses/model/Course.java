package com.uciext.springfw.class01.courses.model;

import java.lang.StringBuilder;

public class Course {

	// Properties
    private String courseId;
    private String courseName;

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

    public String toString() {
       StringBuilder buff = new StringBuilder("[Course: ")
       .append("courseId=").append(courseId)
       .append(", courseName=").append(courseName)
       .append("]")
       ;

       return buff.toString();
    }
}
