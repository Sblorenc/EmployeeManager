package com.sblorenc.EmployeeManager.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String lastname;
	private LocalDate employmentDate;
	private double salary;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id", 
	nullable = true)
	private Department department;
	
	
}
