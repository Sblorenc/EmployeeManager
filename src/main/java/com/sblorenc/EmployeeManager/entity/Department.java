package com.sblorenc.EmployeeManager.entity;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy="department")
	public List <Employee> employees;
	

}
