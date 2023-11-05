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
		return "employeeCreator";
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
		return "listOfEmployees";
	}
	@GetMapping("employeeByIdForm")
		public String employeeByIdForm() {
			return "employeeByIdForm";
		}
	@PostMapping("employeeById")
		public	String employeebyId(@RequestParam Long employeeId, Model model) {
		model.addAttribute("employee", employeeService.findById(employeeId));
		return "employeeById";
	}
	@GetMapping("deleteEmployee")
		public String deleteEmployeeById(@RequestParam String employeeId, Model model) {
			model.addAttribute("employeeId", employeeId);
		return "deleteEmployee";
	}

	@PostMapping("deleteEmployee")
		public String deleteEmployeeById(@RequestParam String employeeId) {
		Long employeeIdToLong = Long.parseLong(employeeId);
		employeeService.deleteById(employeeIdToLong);
		return "redirect:listOfEmployees";
	}
		
		
}

