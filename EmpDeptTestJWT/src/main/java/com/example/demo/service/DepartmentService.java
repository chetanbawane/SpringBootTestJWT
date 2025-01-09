package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repos.DepartmentRepos;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepos departmentRepos; 
	
	public List<Department> getAllDepartments() {
        return departmentRepos.findAll();
    }

    public Optional<Department> getDepartmentById(int id) {
        return departmentRepos.findById(id);
    }

    public Department saveDepartment(Department department) {
        return departmentRepos.save(department);
    }

    public void deleteDepartment(int id) {
        departmentRepos.deleteById(id);
    }
}
