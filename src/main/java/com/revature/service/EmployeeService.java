package com.revature.service;

import java.util.Optional;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {
	private EmployeeDao edao;

	public EmployeeService(EmployeeDao adao) {
		super();
		this.edao = adao;
	}

	public Employee confirmLogin(String username, String password) {
		Optional<Employee> emp = edao.findAll().stream()
				.filter(e -> (e.getUsername().equals(username) && e.getPassword().equals(password))).findFirst();

		return (emp.isPresent() ? emp.get() : null);
	}

	public int insert(Employee e) {
		return edao.insert(e);
	}

	public boolean update(Employee e) {
		return edao.update(e);
	}

	public boolean delete(Employee e) {
		return edao.delete(e);
	}
}
