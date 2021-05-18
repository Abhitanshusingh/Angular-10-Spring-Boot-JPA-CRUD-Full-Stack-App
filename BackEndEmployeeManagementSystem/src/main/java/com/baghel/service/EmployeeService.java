package com.baghel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baghel.exception.ResourceNotFoundException;
import com.baghel.model.Employee;
import com.baghel.repository.EmployeeRepository;
import com.sun.el.stream.Optional;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(Long id) {
		Employee employeeObj = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist by id:" +id));
		return employeeObj;
	}

	public Employee updateEmployee(Long id, Employee employee) {
		Employee employeeObj = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist by id:" +id));
		employee.setFirstName(employee.getFirstName());
		employee.setLastName(employee.getLastName());
		employee.setCity(employee.getCity());
		employee.setMobileNumber(employee.getMobileNumber());
		employee.setAddress(employee.getAddress());
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}
	
	
}
