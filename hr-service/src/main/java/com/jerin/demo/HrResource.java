package com.jerin.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResource {

	List<Employee> employees = Arrays.asList(

			new Employee("E1", "Ram", "Kumar", "MedTech"), 
			new Employee("E2", "Raj", "Kumar", "Surgery"),
			new Employee("E3", "Anil", "Kumar", "Dentistry"));
	
	
	@RequestMapping("/employees")
	public EmployeeList getEmployeeList() {
		EmployeeList employees = new EmployeeList();
		employees.setEmployees(this.employees);
		return employees;
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		Employee emp = employees.stream()
				.filter(e -> e.getId().equalsIgnoreCase(id) )
				.findAny()
				.orElse(null);
		
		return emp;
	}

}
