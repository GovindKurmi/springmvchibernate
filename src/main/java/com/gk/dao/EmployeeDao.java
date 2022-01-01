package com.gk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		employee.setStatus("true");
		Session session = sessionFactory.openSession();
		session.save(employee);
	}

	public List<Employee> getEmployee() {
		Session session = sessionFactory.openSession();
		Query<Employee> query = session.createQuery("from Employee where status='true'");
		List<Employee> employees = query.list();
		return employees;
	}

	public void deleteData(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Employee> q = session.createQuery("update Employee set status=:n where id=:i");
		q.setParameter("n", "false");
		q.setParameter("i", id);
		q.executeUpdate();
		tx.commit();
	}

	public void updateData(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<Employee> q = session.createQuery("update Employee set name=:nam,email=:ema,address=:add where id=:i");
		q.setParameter("nam", employee.getName());
		q.setParameter("ema", employee.getEmail());
		q.setParameter("add", employee.getAddress());
		q.setParameter("i", employee.getId());
		q.executeUpdate();
		tx.commit();
	}

	public Employee fetchbyId(int id) {
		Session session = sessionFactory.openSession();
		Employee emp = session.load(Employee.class, id);
		return emp;
	}
}
