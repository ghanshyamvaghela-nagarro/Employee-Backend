package com.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAll() {
		log.info("calling EmployeeController:: getAll method");
		return ResponseEntity.ok(employeeService.all());
	}

	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employeeDto) {
		log.info("calling EmployeeController:: addEmployee method");
		employeeService.insert(employeeDto);
		
		return ResponseEntity.ok("Employee added");
	}
}
