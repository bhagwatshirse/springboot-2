package com.velocity.service;

import java.util.List;

import com.velocity.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmpById(int id);
	int updateEmployee(Employee employee);
	String deleteEmployeeById(int id);
	List<Employee> getAllEmployeeByPage(int page,int size);
	List<Employee> getAllEmployeeBySorting();
	List<Employee> findByCity(String city);
	Employee findByNameAndCity(String name,String city);

}
