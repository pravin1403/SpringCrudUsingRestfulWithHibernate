package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.model.Employee;

public interface ServiceI {
	
    public Integer addEmp(Employee employee);
	
	public Employee updateEmp(Employee employee);
	
	public List<Employee> getAllEmp();
	
	public Employee loginEmp(Employee employee); 
	
	public Employee deleteEmp(int id);
	
	
	

}
