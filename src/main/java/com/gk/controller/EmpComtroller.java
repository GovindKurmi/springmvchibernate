package com.gk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gk.model.Employee;
import com.gk.service.EmployeeService;

@Controller
public class EmpComtroller {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getView() {
		return "index";
	}

	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String saveEmployee(HttpServletRequest request, Model model) {
		Employee emp = new Employee();
		emp.setName(request.getParameter("name"));
		emp.setEmail(request.getParameter("email"));
		emp.setAddress(request.getParameter("address"));
		emp.setSalary(request.getParameter("salary"));
		employeeService.saveEmployee(emp);
		return "redirect:/viewdata";
	}
	@RequestMapping(value = "/viewdata", method = RequestMethod.GET)
	public String viewData(Model model) {
		  List <Employee> employees = employeeService.getEmployee();
		  model.addAttribute("employee", employees);
	        return "viewpage";
	}

}
