package com.employee.spring_crud_appz.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.employee.spring_crud_appz.model.Employee;
import com.employee.spring_crud_appz.repository.EmployeeRepository;


@Service("employeeService")
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> addAllEmployees(List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}
	
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public Employee updateEmployee(Employee employee, int id) {
		Employee existingEmp = employeeRepository.findById(id).get();
		
		existingEmp.setName(employee.getName());
		existingEmp.setEmail(employee.getEmail());
		existingEmp.setSalary(employee.getSalary());
		existingEmp.setprofile(employee.getprofile());
		existingEmp.setproject(employee.getproject());
		
		return employeeRepository.save(employee);

		
	}

	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
		
	}
}
