package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
	        return employeeService.getEmployeeById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Employee createEmployee(@RequestBody Employee employee) {
	        return employeeService.saveEmployee(employee);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.noContent().build();
}
}
