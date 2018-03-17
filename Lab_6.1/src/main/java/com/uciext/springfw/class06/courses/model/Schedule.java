package com.uciext.springfw.class06.courses.model;

import java.lang.StringBuilder;

import org.apache.log4j.Logger;

public class Schedule {

    protected static Logger logger = Logger.getLogger(Schedule.class.getName());

	// Properties
    private int scheduleId;
    private Course course;
    private int year;
    private int quarter;
    private String instructor;

    // Constructors
    public Schedule() {
	}

    public Schedule(int scheduleId, Course course, int year, int quarter, String instructor) {
 	   this.scheduleId = scheduleId;
	   this.course = course;
	   this.year = year;
	   this.quarter = quarter;
	   this.instructor = instructor;
	}

    // Getters and Setters
    public int getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(int value) {
        this.scheduleId = value;
    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course value) {
        this.course = value;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int value) {
        this.year = value;
    }

    public int getQuarter() {
        return quarter;
    }
    public void setQuarter(int value) {
        this.quarter = value;
    }

    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String value) {
        this.instructor = value;
    }

    public String toString() {
    	StringBuilder buff = new StringBuilder("[Schedule: ")
       .append("scheduleId=").append(getScheduleId())
       .append(", course=").append(getCourse())
       .append(", year=").append(getYear())
       .append(", quarter=").append(getQuarter())
       .append(", instructor=").append(getInstructor())
       .append("]")
       ;

       return buff.toString();
    }
}
