package com.sblorenc.EmployeeManager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import com.sblorenc.EmployeeManager.entity.Department;
import com.sblorenc.EmployeeManager.entity.Employee;
import com.sblorenc.EmployeeManager.service.DepartmentService;
import com.sblorenc.EmployeeManager.service.EmployeeService;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class DepartmentController {
	private final DepartmentService departmentService;
	private final EmployeeService employeeService;
	
	@GetMapping("departmentCreator")
	public String departmentCreator(Model model) {
		model.addAttribute("employees",employeeService.findAll());
		model.addAttribute("department", new Department());
		return "departmentTemplates/departmentCreator";
	}
	@PostMapping("departmentCreator")
	public String departmentCreator(@RequestParam String departmentName,@RequestParam List<Employee> employees) {
		Department department = new Department();
		department.setName(departmentName);
		department.setEmployees(employees);
		for (Employee employee:employees) {
			employee.setDepartment(department);
		}
		departmentService.save(department);
		
		return "redirect:listOfDepartments";
	}
	@GetMapping("listOfDepartments")
	public String getListOfDepartments(Model model) {
		model.addAttribute("departments",departmentService.findAll());
		return "departmentTemplates/departmentList";
	}
	@GetMapping("departmentById")
	public String departmentById(Model model) {
		model.addAttribute("departments",departmentService.findAll());
		return "departmentTemplates/departmentByIdForm";
	}
	@PostMapping("departmentById")
	public String departmentById(@RequestParam Long departmentId, Model model) {
		model.addAttribute("department",departmentService.findById(departmentId));
		return "departmentTemplates/departmentById";
	}
	@GetMapping("deleteDepartment")
	public String deleteDepartmentById(Model model,@RequestParam Long departmentId) {
		model.addAttribute("department",departmentService.findById(departmentId));
		return "departmentTemplates/deleteDepartment";
	}
	@PostMapping("deleteDepartment")
		public String deleteDepartmentById(@RequestParam Long departmentId, @RequestParam boolean confirm) {
		if (confirm == true) {
			List<Employee>employeesList = employeeService.findByDepartment(departmentService.findById(departmentId));
			
			for (Employee employee:employeesList) {
				employee.setDepartment(null);
			}			
			departmentService.deleteById(departmentId);
		}
			return "redirect:listOfDepartments";
		}
	@GetMapping("updateDepartment")
	public String updateDepartment(Model model,@RequestParam Long departmentId) {
		Department department = departmentService.findById(departmentId);
		List<Employee>employees = employeeService.findAll();
		model.addAttribute("employees",employees);
		model.addAttribute("department",department);
		return "departmentTemplates/updateDepartment";
	}
	@PostMapping("updateDepartment")
	public String updateDepartment(@RequestParam String departmentName, @RequestParam List<Employee>employees, @RequestParam Long departmentId) {
		Department department = departmentService.findById(departmentId);
		department.setEmployees(employees);
		for (Employee employee:employees) {
			employee.setDepartment(department);
		}
		department.setName(departmentName);
		departmentService.update(department);
		return "redirect:listOfDepartments";
	}
}
	

