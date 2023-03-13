package com.employee.spring_crud_appz.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.spring_crud_appz.model.Employee;
import com.employee.spring_crud_appz.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*") 
@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	//Add new employee
	@PostMapping("/addEmployee")
	@CrossOrigin(origins = "http://localhost:4200/")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	//Add more than one employee
	@PostMapping("/addEmployees")
	@CrossOrigin(origins = "http://localhost:4200/")
	public List<Employee> addAllEmployees(@RequestBody List<Employee> employees) {
		return employeeService.addAllEmployees(employees);
	}
	
	//Get All employees
	@GetMapping("/getAllEmployees")
	@CrossOrigin(origins = "http://localhost:4200/")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	//Get employee by Id
	@GetMapping("/getEmployeeByID/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	//Update employee
	@PutMapping("/updateEmployee/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		return employeeService.updateEmployee(employee,id);
	}
	
	//Delete employee by Id
	@DeleteMapping("/deleteEmployeeByID/{id}")
	@CrossOrigin(origins = "http://localhost:4200/")
	public void deleteEmployeeById(@PathVariable("id") Integer id) {
		employeeService.deleteEmployeeById(id);
	}
}
