package com.baghel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baghel.model.Employee;
import com.baghel.service.EmployeeService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/baghelv1/")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	
	@GetMapping("/employees")
	private ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok().body(employeeService.getAllEmployee());
	}
	
	@PostMapping("/employees")
	private ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok().body(employeeService.addEmployee(employee));
	}
	
	@GetMapping("/employees/{id}")
	private ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}
	
	@PutMapping("/employees/{id}")
	private ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		return ResponseEntity.ok().body(employeeService.updateEmployee(id,employee));
		
	}
	
	@DeleteMapping("employee/{id}")
	private ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id,@RequestBody Employee employee){
		return ResponseEntity.ok().body(employeeService.deleteEmployee(id,employee));
	}
		
}
