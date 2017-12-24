package com.broadway.studentproject.dao;

import java.util.List;

import com.broadway.studentproject.dto.Student;

public interface StudentDao {
	public void saveStudentInfo(Student student);

	public void updateStudentInfo(Student student);

	public void deletStudentInfo(int id);

	public List<Student> getAllStudentInfo();

	public Student getStudentInfoById(int id);
	
	public String getImageUrl(int id);
}
