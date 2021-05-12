package com.baghel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baghel.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
