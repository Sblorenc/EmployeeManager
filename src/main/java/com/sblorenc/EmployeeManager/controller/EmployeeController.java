package com.sblorenc.EmployeeManager.controller;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.sblorenc.EmployeeManager.entity.Employee;
import com.sblorenc.EmployeeManager.repository.EmployeeRepository;
import com.sblorenc.EmployeeManager.service.EmployeeService;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	
	@GetMapping("employeeCreator")
	public String EmployeeCreator(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeTemplates/employeeCreator";
	}
	
	@PostMapping ("employeeCreator")
		public String EmployeeCreator(@RequestParam String firstname, @RequestParam String lastname, @RequestParam LocalDate employmentDate, @RequestParam double salary) {
		Employee employee = new Employee();
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setEmploymentDate(employmentDate);
		employee.setSalary(salary);
		employeeService.save(employee);
		return "redirect:listOfEmployees";
	}
	
	@GetMapping("listOfEmployees")
		public String getListOfEmployees(Model model) {
		model.addAttribute("employeesList",employeeService.findAll());
		return "employeeTemplates/listOfEmployees";
	}
	@GetMapping("employeeByIdForm")
		public String employeeByIdForm() {
			return "employeeTemplates/employeeByIdForm";
		}
	@PostMapping("employeeById")
		public	String employeebyId(@RequestParam Long employeeId, Model model) {
		model.addAttribute("employee", employeeService.findById(employeeId));
		return "employeeTemplates/employeeById";
	}
	@GetMapping("deleteEmployee")
		public String deleteEmployeeById(@RequestParam Long employeeId, Model model) {
			model.addAttribute("employeeId", employeeId);
		return "employeeTemplates/deleteEmployee";
	}

	@PostMapping("deleteEmployee")
		public String deleteEmployeeById(@RequestParam Long employeeId) {
		employeeService.deleteById(employeeId);
		return "redirect:listOfEmployees";
	}
	@GetMapping("updateEmployee")
	public String updateEmployee(@RequestParam Long employeeId, Model model) {
		model.addAttribute("employee", employeeService.findById(employeeId));
		return "employeeTemplates/updateEmployee";
	}
	@PostMapping("updateEmployee")
	public String updateEmployee(@RequestParam String firstname, @RequestParam String lastname, @RequestParam double salary, @RequestParam LocalDate employmentDate, @RequestParam Long employeeId) {
		Employee employee = employeeService.findById(employeeId);
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setEmploymentDate(employmentDate);
		employee.setSalary(salary);
		employeeService.update(employee);
		return "redirect:listOfEmployees";
	}
		
}

