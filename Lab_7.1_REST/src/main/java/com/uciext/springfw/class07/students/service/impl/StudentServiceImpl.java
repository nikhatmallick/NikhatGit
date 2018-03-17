package com.uciext.springfw.class07.students.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.uciext.springfw.class07.courses.model.Schedule;
import com.uciext.springfw.class07.students.dao.RegistrationDao;
import com.uciext.springfw.class07.students.dao.StudentDao;
import com.uciext.springfw.class07.students.model.Registration;
import com.uciext.springfw.class07.students.model.Student;
import com.uciext.springfw.class07.students.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private static Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());

    // DAO classes
    private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

    private RegistrationDao registrationDao;	
	public void setRegistrationDao(RegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

    //----------------------------------------------
	// Students
	
    @Override
	public Student getStudent(int studentId) {
		System.out.println("--- getStudent() studentId=" + studentId);
		return studentDao.findStudentById(studentId);
	}

    @Override
	public void insertStudent(Student student) {
		System.out.println("--- insertStudent() student=" + student);
		studentDao.insertStudent(student);
	}
	
    @Override
	public List<Student> getStudents() {
		System.out.println("--- getStudents");
		return studentDao.findStudents();
	}

    //----------------------------------------------
	// Registrations
	
    @Override
	public Registration getRegistration(int registrationId) {
		System.out.println("--- getRegistration() registrationId=" + registrationId);
		return registrationDao.findRegistrationById(registrationId);
	}

    @Override
	public void insertRegistration(Registration registration) {
		System.out.println("--- insertRegistration() registration=" + registration);
		registrationDao.insertRegistration(registration);
	}

    @Override
	public List<Registration> getRegistrations() {
		System.out.println("--- getRegistrations");
		return registrationDao.findRegistrations();
	}

    @Override
	public List<Registration> getRegistrationsByStudent(Student student) {
		System.out.println("--- getRegistrationByStudent");
		return registrationDao.findRegistrationsByStudent(student);
	}

    @Override
	public List<Registration> getRegistrationsBySchedule(Schedule schedule) {
		System.out.println("--- getRegistrationBySchedule");
		return registrationDao.findRegistrationsBySchedule(schedule);
	}

}
