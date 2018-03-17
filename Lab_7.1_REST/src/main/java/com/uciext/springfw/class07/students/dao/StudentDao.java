package com.uciext.springfw.class07.students.dao;

import java.util.List;

import com.uciext.springfw.class07.courses.model.Course;
import com.uciext.springfw.class07.students.model.Registration;
import com.uciext.springfw.class07.students.model.Student;

public interface StudentDao {
	
	public void insertStudent(Student student);
	public List<Student> findStudents();
	public Student findStudentById(int studentId);

}
