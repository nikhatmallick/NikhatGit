package com.uciext.springfw.class05.students.model;

public class Student {

	private int studentId;
	private String studentName;

	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
	    this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
	    this.studentName = studentName;
	}
	
	public String toString() {
        StringBuilder buff = new StringBuilder("[Student: ")
        .append("studentId=").append(studentId)
        .append(", studentName=").append(studentName)
        .append("]")
        ;

        return buff.toString();
	}
}
