package com.employee.spring_crud_appz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee_db")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="project")
	private String project;
	
	@Column(name="email")
	private String email;
	
	@Column(name="profile")
	private String profile;
	
	@Column(name="salary")
	private int salary;

	public String getproject(){
	return project;
	}
	public void setproject(String project)
	{
	this.project = project;
	}
	
	public String getprofile(){
	return profile;
	}
	public void setprofile(String profile)
	{
	this.profile = profile;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
