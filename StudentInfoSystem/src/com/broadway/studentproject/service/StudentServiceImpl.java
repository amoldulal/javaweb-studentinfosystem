package com.broadway.studentproject.service;

import java.util.List;

import com.broadway.studentproject.dao.StudentDao;
import com.broadway.studentproject.dao.StudentDaoImpl;
import com.broadway.studentproject.dto.Student;

public class StudentServiceImpl implements StudentService{
StudentDao studentDao=new StudentDaoImpl();

	@Override
	public void saveStudentInfo(Student student) {
		
		studentDao.saveStudentInfo(student);
	}

	@Override
	public void updateStudentInfo(Student student) {
		studentDao.updateStudentInfo(student);
		
	}

	@Override
	public void deleteStudentInfo(int id) {
		studentDao.deletStudentInfo(id); 
		
	}

	@Override
	public List<Student> getAllStudentInfo() {
		
		return studentDao.getAllStudentInfo();
	}

	@Override
	public Student getStudentInfoById(int id) {
		
		return studentDao.getStudentInfoById(id);
	}

	@Override
	public String getImageUrl(int id) {
		return studentDao.getImageUrl(id);
	}

}
