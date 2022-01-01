package com.gk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gk.model.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.save(employee);
	}

	public List<Employee> getEmployee() {
		Session session = sessionFactory.openSession();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		return employees;

	}
}
