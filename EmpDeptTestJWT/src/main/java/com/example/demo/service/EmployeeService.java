package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repos.EmployeeRepos;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepos employeeRepos;
	

	    public List<Employee> getAllEmployees() {
	        return employeeRepos.findAll();
	    }

	    public Optional<Employee> getEmployeeById(int id) {
	        return employeeRepos.findById(id);
	    }

	    public Employee saveEmployee(Employee employee) {
	        return employeeRepos.save(employee);
	    }

	    public void deleteEmployee(int id) {
	        employeeRepos.deleteById(id);
	    }
}
