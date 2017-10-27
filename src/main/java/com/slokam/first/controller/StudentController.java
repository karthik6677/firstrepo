package com.slokam.first.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.first.pojo.StudentPojo;
import com.slokam.first.service.IStudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	private IStudentService studentservice;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<StudentPojo> getStudent(@PathVariable Integer id) {
		StudentPojo std = studentservice.getStudent(id);
		logger.trace("trace getStudent method started");//trace , debug , info , warn , error , fatal
		logger.debug("debug getStudent method started");
		logger.info("info getStudent method started");
		logger.warn("warn getStudent method started");
		logger.error("error getStudent method started");
		logger.fatal("fatal getStudent method started");
		ResponseEntity response = null;
		if(std!=null) {
			logger.debug("checking getStudent ID"+id);
		response =new ResponseEntity(std,HttpStatus.OK);
		}else {
			response =new ResponseEntity(HttpStatus.NOT_FOUND);	
		}
		logger.debug("getStudent method Ended");
		return response;
	}
	@RequestMapping(value="/all" , method = RequestMethod.GET)
	public List<StudentPojo> getAllStudent() {
		return studentservice.getAllStudent();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity saveStudent(@Valid @RequestBody StudentPojo student,BindingResult result) {
		ResponseEntity responseEntity = null;
		if(result.hasErrors()) {
			responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		try {
			studentservice.saveStudent(student);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity(HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/all",method = RequestMethod.POST)
	public void saveStudents(@RequestBody List<StudentPojo> students) {
		studentservice.saveStudents(students);
		System.out.println(students);
	}
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteStudent(@RequestBody StudentPojo student) {
		studentservice.deleteStudent(student);
	}
}
