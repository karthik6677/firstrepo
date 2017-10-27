package com.slokam.first.pojo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="student")
public class StudentPojo {
	
	@Id
	@GeneratedValue
	public Integer id;
	
	@NotBlank
	@Email
	public String name;
	public Integer age;
	@Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]$")
	public String qual;
	public String phone;
	
	public StudentPojo() {
		
	}
	
	public StudentPojo(Integer id, String name, Integer age, String phone) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getQual() {
		return qual;
	}
	
	public void setQual(String qual) {
		this.qual = qual;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
