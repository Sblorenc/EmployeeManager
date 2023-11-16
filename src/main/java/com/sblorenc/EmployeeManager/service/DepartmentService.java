package com.sblorenc.EmployeeManager.service;

import java.util.List;

import com.sblorenc.EmployeeManager.entity.Department;
import com.sblorenc.EmployeeManager.entity.Employee;

public interface DepartmentService {
	void save (Department department);
	List <Department> findAll();
	Department findById(Long id);
	void deleteById(Long id);
	void update(Department department);

}
