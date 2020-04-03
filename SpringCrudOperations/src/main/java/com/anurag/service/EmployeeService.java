package com.anurag.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.bean.Employee;
import com.anurag.dao.EmployeeDao;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceIn {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public Employee getEmployeeDetails(int id) {
		return dao.getEmployeeDetails(id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return dao.createEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}

	@Override
	public Employee deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

	@Override
	public List<Object> fetchAllEmployees() {
		return dao.fetchAllEmployees();
	}
}