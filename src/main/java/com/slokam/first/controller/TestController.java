package com.slokam.first.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.first.pojo.StudentPojo;

@RestController
public class TestController {
	@RequestMapping("getData")
	public String getData() {
		return "karthik";
}
	@RequestMapping("getStringData")
	public String[] getStringData() {
		String arr[] = {"karthik","ram","bheem"};
		
		return arr;
}
	@RequestMapping("getStudentData")
	public StudentPojo getStudentData() {
		StudentPojo std = new StudentPojo(1, "karthik", 24, "sffsff");
		return std;
}
	@RequestMapping("getListStudentData")
	public List<StudentPojo> getListStudentData() {
		StudentPojo std = new StudentPojo(1, "karthik", 24, "sffsff");
		StudentPojo std1 = new StudentPojo(2, "bheem", 24, "sgsag");
		StudentPojo std2 = new StudentPojo(3, "ram", 24, "ngjdfng");
		
		List<StudentPojo> list = new ArrayList<>();
		list.add(std);
		list.add(std1);
		list.add(std2);
		
		
		return list;
}
	@RequestMapping("getMapData")
	public Map<Integer , String> getMapData() {
		
		
		Map<Integer , String> map = new HashMap<>();
		map.put(1, "karthik");
		map.put(2, "ram");
		map.put(3, "bheem");
		
		
		
		return map;
}
	@RequestMapping("getMapStudentData")
	public Map<Integer , StudentPojo> getMapStudentData() {
		StudentPojo std = new StudentPojo(1, "karthik", 24, "sffsff");
		StudentPojo std1 = new StudentPojo(2, "bheem", 24, "sgsag");
		StudentPojo std2 = new StudentPojo(3, "ram", 24, "ngjdfng");
		
		Map<Integer , StudentPojo> map = new HashMap<>();
		map.put(1,std );
		map.put(2, std1);
		map.put(3,std2);
		
		
		
		return map;
}
}