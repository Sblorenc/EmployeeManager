package com.sblorenc.EmployeeManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sblorenc.EmployeeManager.entity.Department;
import com.sblorenc.EmployeeManager.entity.Employee;

public interface DepartmentRepository extends JpaRepository <Department,Long>{
	
	Optional<Department>findById(@Param("id")Long id);
	void deleteById(@Param("id")Long id);
	
	
}
