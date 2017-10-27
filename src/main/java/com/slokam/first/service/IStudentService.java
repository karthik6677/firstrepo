package com.slokam.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.first.pojo.StudentPojo;

@Service
public interface IStudentService {
	
	public StudentPojo getStudent(Integer id);

	public List<StudentPojo> getAllStudent();

	public void saveStudent(StudentPojo student) throws Exception;

	public void saveStudents(List<StudentPojo> students);

	public void deleteStudent(StudentPojo student);

}
