package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gk.model.Employee;
import com.gk.service.EmployeeService;

@Controller
public class EmpComtroller {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String getView(Model model) {
		model.addAttribute("employee", new Employee());
		return "index";
	}

	@RequestMapping(value = "/savedata", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewData(Model model) {
		List<Employee> employees = employeeService.getEmployee();
		model.addAttribute("employee", employees);
		return "viewpage";
	}

	@RequestMapping(value = "employee/updateForm", method = RequestMethod.PUT)
	public String fetchbyId(@RequestParam("id") int id, Model model) {
		Employee emp = employeeService.fetchbyId(id);
		model.addAttribute("employee", emp);
		return "update";
	}
	

	@RequestMapping(value = "employee/delete", method = RequestMethod.GET)
	public String deleteData(@RequestParam("id") int id) {
		employeeService.deleteData(id);
		System.out.println(id);
		return "redirect:/";
	}

}
