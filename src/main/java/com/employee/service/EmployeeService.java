package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;

public interface EmployeeService {

	Optional<Employee> findById(String id);
	Optional<Employee> findByName(String name);
	List<Employee> all();
	void insert(EmployeeDto employeeDto);
	Optional<Employee> update(EmployeeDto employeeDto);
	void deleteById(String id);
}
