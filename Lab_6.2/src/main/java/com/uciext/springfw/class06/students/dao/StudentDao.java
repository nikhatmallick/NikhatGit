package com.uciext.springfw.class06.students.dao;

import java.util.List;

import com.uciext.springfw.class06.courses.model.Course;
import com.uciext.springfw.class06.students.model.Registration;
import com.uciext.springfw.class06.students.model.Student;

public interface StudentDao {
	
	public void insertStudent(Student student);
	public List<Student> findStudents();
	public Student findStudentById(int studentId);

}
