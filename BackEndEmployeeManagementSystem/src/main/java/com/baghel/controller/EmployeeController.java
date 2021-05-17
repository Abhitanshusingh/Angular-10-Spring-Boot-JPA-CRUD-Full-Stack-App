package com.baghel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baghel.model.Employee;
import com.baghel.service.EmployeeService;

@RestController
@RequestMapping("/api/baghelv1/")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@CrossOrigin
	@GetMapping("/employees")
	private ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok().body(employeeService.getAllEmployee());
	}
	
	@CrossOrigin
	@PostMapping("/employees")
	private Employee createEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}

}
