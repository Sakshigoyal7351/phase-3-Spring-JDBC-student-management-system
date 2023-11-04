package com.day2.dao;

import java.util.List;

import com.day2.Student;

public interface studentDao {

	public int insert(Student student);// add
	
	public int change(Student student);// update
	
	public int delete(int studentId); //delete
	
	public List<Student> getAllStudents(); // display all students
	
	public Student getStudent(int studentId); // display single student
	
	
}
