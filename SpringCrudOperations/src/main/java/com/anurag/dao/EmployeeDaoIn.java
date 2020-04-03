package com.anurag.dao;

import java.util.List;

import com.anurag.bean.Employee;

public interface EmployeeDaoIn {

	Employee getEmployeeDetails(int id);

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee deleteEmployee(int id);

	List<Object> fetchAllEmployees();

}
