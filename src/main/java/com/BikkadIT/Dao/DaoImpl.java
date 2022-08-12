package com.BikkadIT.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikkadIT.model.Employee;

@Repository
public class DaoImpl implements DaoI{
	
	@Autowired
	private SessionFactory sf;
	

	@Override
	public Integer addEmployee(Employee employee) {
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		int id =(int) session.save(employee);
		
		
		
		return id;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		  
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.update(employee);
		session.getTransaction().commit();
		
		Session session2 = sf.openSession();
		
		Employee employee2 = session2.get(Employee.class, employee.getEmpId());
		
		return employee2;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sf.openSession();
		String hql="from Employee";
		Query qurey= session.createQuery(hql);
		
		List resultList = qurey.getResultList();
		
		return resultList;
	}

	@Override
	public Employee loginEmployee(Employee employee) {
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		String hql="from User";
		Query query = session.createQuery(hql);
		
		List<Employee> list = query.getResultList();
		
		for(Employee emp:list) {
			if(employee.getEmpName().equals(emp.getEmpName()) && (employee.getEmpPwd().equals(emp.getEmpPwd()))) {
				
			return emp;	
			}
		}
		return null;
		
		
		
	}

	@Override
	public Employee deleteEmpById(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class,id);
		if(employee!=null) {
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		}
		
		return employee;
	}

	
	
	
	
	
}
