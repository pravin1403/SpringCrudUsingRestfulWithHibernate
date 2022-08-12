package com.BikkadIT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Dao.DaoImpl;
import com.BikkadIT.model.Employee;

@Service
public class ServiceImpl implements ServiceI {
	
	@Autowired
	private DaoImpl dao;

	@Override
	public Integer addEmp(Employee employee) {
		
		 Integer addEmployee = dao.addEmployee(employee);
		 
		
		return addEmployee;
	}

	@Override
	public Employee updateEmp(Employee employee) {
		Employee updateEmployee = dao.updateEmployee(employee);
		
		return updateEmployee;
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> allEmployee = dao.getAllEmployee();
		return allEmployee;
	}

	@Override
	public Employee loginEmp(Employee employee) {
		Employee loginEmployee = dao.loginEmployee(employee);
		return loginEmployee;
	}

	@Override
	public Employee deleteEmp(int id) {
		Employee deleteEmpById = dao.deleteEmpById(id);
		
		return  deleteEmpById;
	}
	
	

}
