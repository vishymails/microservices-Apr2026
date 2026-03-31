package com.bvr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResource {

	public HrResource() {
		// TODO Auto-generated constructor stub
	}
	
	List<Employee> employees = Arrays.asList(
			new Employee("1", "John", "Doe", "Medical Tech"),
			new Employee("2", "Jane", "Smith", "Nurse"),
			new Employee("3", "Bob", "Johnson", "Surgeon")	
	);


	@RequestMapping("/employees")
	public EmployeeList getEmployees() {
		EmployeeList empList = new EmployeeList();
		empList.setEmployees(employees);
		return empList;
	}

	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") String id) {
		Employee emp = employees.stream()
				.filter(e -> id.equals(e.getId()))
				.findAny()
				.orElse(null);
		return emp;
	}

}
