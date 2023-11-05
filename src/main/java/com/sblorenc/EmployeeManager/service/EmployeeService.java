package com.sblorenc.EmployeeManager.service;

import java.util.*;


import com.sblorenc.EmployeeManager.entity.Employee;


public interface EmployeeService{
	List<Employee>findAll();
	
	Employee findById(Long id);
	
	void save (Employee employee);
	
	void deleteById(Long id);

}
