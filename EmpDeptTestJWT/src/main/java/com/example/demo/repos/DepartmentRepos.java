package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface DepartmentRepos extends JpaRepository<Department, Integer> {

}
