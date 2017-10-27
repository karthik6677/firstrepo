package com.slokam.first.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.slokam.first.dao.StudentDao;
import com.slokam.first.exception.DuplicateException;
import com.slokam.first.pojo.StudentPojo;
import com.slokam.first.util.SpringUtil;

@Service
@Primary
public class StudentService implements IStudentService{
	
	@Autowired
	private SpringUtil su;
	
	@Autowired
	private StudentDao studentdao;
	
	public StudentPojo getStudent(Integer id) {
		return studentdao.findOne(id);
	}
	
	public List<StudentPojo> getAllStudent() {
		su.test();
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
