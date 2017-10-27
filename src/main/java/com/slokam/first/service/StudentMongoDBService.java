package com.slokam.first.service;

import java.util.List
;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.slokam.first.dao.StudentDao;
import com.slokam.first.exception.DuplicateException;
import com.slokam.first.pojo.StudentPojo;

@Service
public class StudentMongoDBService implements IStudentService {
	@Autowired
	private StudentDao studentdao;
	
	public StudentPojo getStudent(Integer id) {
		return studentdao.findOne(id);
	}
	
	public List<StudentPojo> getAllStudent() {
		return studentdao.findAll();
	}
	
	public void saveStudent(StudentPojo student) throws Exception{
		List<StudentPojo> list = studentdao.findByName(student.getName());
		if(list.size()>0) {
			throw new DuplicateException();
		}
		studentdao.save(student);
	}
	
	public void saveStudents(List<StudentPojo> students) {
		studentdao.save(students);
		System.out.println(students);
	}
	
	public void deleteStudent(StudentPojo student) {
		studentdao.delete(student);
	}
}
