package com.slokam.first.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.first.pojo.StudentPojo;

@Repository
public interface StudentDao extends JpaRepository<StudentPojo, Integer>{
	public List<StudentPojo> findByName(String name);
}
