package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Optional<Employee> findById(String id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Optional<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> all() {
		return employeeRepository.findAll();
	}

	@Override
	public void insert(EmployeeDto employeeDto) {

		Employee employee = new Employee(null, employeeDto.getName(), employeeDto.getDepartment(),
				employeeDto.getAddress());
		employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> update(EmployeeDto employeeDto) {
		
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteById(String id) {
		employeeRepository.deleteById(id);
	}
}
