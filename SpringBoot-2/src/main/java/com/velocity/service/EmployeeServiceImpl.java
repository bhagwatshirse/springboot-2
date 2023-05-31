package com.velocity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.velocity.entity.Employee;
import com.velocity.repository.EmployeeRepository;

@Service 
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Iterable<Employee> iterable = employeeRepository.findAll();
		
		return (List<Employee>) iterable;
	}

	@Override
	public Employee getEmpById(int id) {
		Optional<Employee> response = employeeRepository.findById(id);
		return response.isPresent()? response.get(): null ;
	}

	@Override
	public int updateEmployee(Employee employee) {
	Employee response = employeeRepository.save(employee);
	response.getId();
		return response.getId();
	}

	@Override
	public String deleteEmployeeById(int id) {
		 employeeRepository.deleteById(id);
		 return "employee deleted";
		
		
	}

	@Override
	public List<Employee> getAllEmployeeByPage(int page, int size) {
		PageRequest request = PageRequest.of(page, size);
		Page<Employee> pageResponse= employeeRepository.findAll(request);
		List<Employee> employeesResponse = pageResponse.getContent();
		return employeesResponse;
	}

	@Override
	public List<Employee> getAllEmployeeBySorting() {
		List<Employee> findAll = employeeRepository.findAll(Sort.by("name").ascending());
		return findAll;
	}

	@Override
	public List<Employee> findByCity(String city) {
		List<Employee> findByCity = employeeRepository.findByCity(city);
		return findByCity;
	}

	@Override
	public Employee findByNameAndCity(String name, String city) {
	    Employee findByNameAndCity = employeeRepository.findByNameAndCity(name, city);
		return findByNameAndCity;
	}
	

}
