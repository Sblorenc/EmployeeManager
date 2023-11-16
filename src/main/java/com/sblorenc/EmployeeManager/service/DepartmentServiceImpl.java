package com.sblorenc.EmployeeManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sblorenc.EmployeeManager.entity.Department;
import com.sblorenc.EmployeeManager.entity.Employee;
import com.sblorenc.EmployeeManager.repository.DepartmentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	private final DepartmentRepository departmentRepository;
	
	@Override
	public void save (Department department) {
		departmentRepository.save(department);
	}
	@Override
	public List <Department> findAll(){
		return departmentRepository.findAll();
	}
	@Override
	public Department findById(Long id) {
		return departmentRepository.findById(id).get();
	}
	@Override
	public void deleteById(Long id) {
		departmentRepository.deleteById(id);
	}
	@Override
	public void update(Department department) {
		departmentRepository.save(department);
	}
	

}
