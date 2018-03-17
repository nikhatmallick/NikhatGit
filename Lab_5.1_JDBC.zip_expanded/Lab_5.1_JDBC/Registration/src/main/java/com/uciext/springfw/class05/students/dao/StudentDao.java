package com.uciext.springfw.class05.students.dao;

import java.util.List;

import com.uciext.springfw.class05.courses.model.Course;
import com.uciext.springfw.class05.students.model.Student;
import com.uciext.springfw.class05.students.model.Registration;

public interface StudentDao {
	
	public void insertStudent(Student student);
	public List<Student> findStudents();
	public Student findStudentById(int studentId);

}
