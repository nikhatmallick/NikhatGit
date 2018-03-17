package com.uciext.springfw.class02.courses.model;

import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Course {

    private static Logger logger = Logger.getLogger(Course.class.getName());

	// Properties
    private String courseId;
    private String courseName;
    private List<Schedule> schedules;
    private Instructor instructor;

    // Constructors
    public Course() {
	}

    public Course(String courseId, String courseName, Instructor instructor) {
       this.courseId = courseId;
       this.courseName = courseName;
       this.instructor = instructor;
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

    public Instructor getInstructor() {
        return instructor;
    }
    public void setInstructor(Instructor value) {
        this.instructor = value;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<Schedule> value) {
        this.schedules = value;
    }
    public void addSchedule(Schedule schedule) {
    	if (schedules == null) {
    		schedules = new ArrayList();
    	}
        schedules.add(schedule);
    }

    public String toString() {
       StringBuilder buff = new StringBuilder("[Course: ")
       .append("courseId=").append(courseId)
       .append(", courseName=").append(courseName)
       .append(", instructor=").append(instructor)
       ;
       if (schedules != null) {
    	   buff.append(", schedules");
    	   for (Schedule schedule : schedules) {
    		   buff.append(schedule).append(", ");
    	   }
       }
       else {
    	   buff.append(", schedules=null");
       }
       buff.append("]")
       ;

       return buff.toString();
    }
}
