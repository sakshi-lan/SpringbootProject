package com.anurag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.bean.Employee;
import com.anurag.service.EmployeeService;

@RestController
@RequestMapping("/bank")
@CrossOrigin("http://localhost:8080")
public class MyController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/getEmployeeDetails/{enter Employee id here}")
	public Employee getEmployeeDetails(@PathVariable ("enter Employee id here") int id){
		return service.getEmployeeDetails(id);
	}

	@PostMapping("/createEmployee")
	public String createEmployee(@RequestBody Employee employee) {
		Employee emp = service.createEmployee(employee);
		if(emp == null) {
			return "Sorry, unable to insert the Employee";
		}
		else {
			return "Employee was inserted successfully!!";
		}
	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		Employee emp = service.updateEmployee(employee);
		if(emp != null) {
			return "Employee details were updated successfully!!"+"\nEmployee ID : "+employee.getEid()+"\nEmployee Name : "+
					employee.getEname()+"\nEmployee Salary : "+employee.getEsal();
		}
		else {
			return "Sorry, employee details were not updated";
		}
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable ("id") int id) {
		Employee emp = service.deleteEmployee(id);
		if(emp == null) {
			return "Sorry, employee deatils were not deleted";
		}
		else {
			return "Employee details were deleted successfully!!";
		}
	}
	
	@GetMapping("/fetchAllEmployees")
	public List<Object>fetchAllEmployees(){
		List <Object>list = service.fetchAllEmployees();
		return list;
	}
}
