package com.uciext.springfw.class05.students.service;

import java.util.List;

import com.uciext.springfw.class05.courses.model.Schedule;
import com.uciext.springfw.class05.students.model.Registration;
import com.uciext.springfw.class05.students.model.Student;

public interface StudentService {
	
	// Students
	public Student getStudent(int studentId);
	public void insertStudent(Student student);
	public List<Student> getStudents();

	// Registrations
	public Registration getRegistration(int registrationId);
	public void insertRegistration(Registration registration);
	public List<Registration> getRegistrations();
	public List<Registration> getRegistrationsByStudent(Student student);
	public List<Registration> getRegistrationsBySchedule(Schedule schedule);

}
