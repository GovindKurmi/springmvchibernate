package com.gk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.EmployeeDao;
import com.gk.model.Employee;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	public List<Employee> getEmployee() {
		return employeeDao.getEmployee();
	}
}
