package com.sblorenc.EmployeeManager.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.sblorenc.EmployeeManager.entity.Employee;
import com.sblorenc.EmployeeManager.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	
	private final EmployeeRepository employeeRepository;

	@Override
	public List<Employee>findAll(){
		return employeeRepository.findAll();
	}
	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).get();
	}
	
	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
}
