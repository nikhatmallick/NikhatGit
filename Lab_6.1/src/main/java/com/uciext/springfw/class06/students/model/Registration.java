package com.uciext.springfw.class06.students.model;

import java.util.Date;

import com.uciext.springfw.class06.courses.model.Schedule;

public class Registration {

	private int registrationId;
	private Student student;
	private Schedule schedule;
	private Date registrationDate;

	public Registration(int registrationId, Student student, 
			Schedule schedule, Date registrationDate) {
		this.registrationId = registrationId;
		this.student = student;
		this.schedule = schedule;
		this.registrationDate = registrationDate;
	}
	
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
	    this.registrationId = registrationId;
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
	    this.student = student;
	}

    public Schedule getSchedule() {
        return schedule;
    }
    public void setSchedule(Schedule value) {
        this.schedule = value;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Date value) {
        this.registrationDate = value;
    }
	
	public String toString() {
        StringBuilder buff = new StringBuilder("[Registration: ")
        .append("registrationId=").append(registrationId)
        .append(", student=").append(student)
        .append(", schedule=").append(schedule)
        .append(", registrationDate=").append(registrationDate)
        .append("]")
        ;

        return buff.toString();
	}
}
