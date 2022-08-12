package com.BikkadIT.Dao;

import java.util.List;

import com.BikkadIT.model.Employee;

public interface DaoI {

	public Integer addEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee loginEmployee(Employee employee); 
	
	public Employee deleteEmpById(int id);
	
	
	
}
