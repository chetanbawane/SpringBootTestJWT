package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity(name = "employee")
@Data
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	
	@Column
	private String EmpName,Job,Manager;
	
	@Column
	private Date date;
	
	@Column
	private long Salary;
	
	@Column
	private int	Commission;
	
	@ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
