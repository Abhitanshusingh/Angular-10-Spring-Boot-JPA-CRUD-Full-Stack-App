package com.baghel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baghel.model.Employee;
import com.baghel.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/baghelv1/")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees")
	private List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
