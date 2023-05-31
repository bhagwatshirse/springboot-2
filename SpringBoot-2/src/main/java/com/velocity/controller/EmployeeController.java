package com.velocity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.entity.Employee;
import com.velocity.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path="/save",consumes= {MediaType.APPLICATION_XML_VALUE},produces= {MediaType.APPLICATION_XML_VALUE})
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		}
	
	@GetMapping("/allEmp")
	public List<Employee> getAll(){
		return employeeService.getAllEmployee();
		
	}
	@GetMapping(path="/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Employee getEmpById(@PathVariable int id){
	Employee employee=employeeService.getEmpById(id);
	return employee;
		
	}
	@GetMapping("/request")
	public Employee getById(@RequestParam("empcode") int id){
	Employee employee=employeeService.getEmpById(id);
	return employee;
		
	}
	@PutMapping("/update")
	public String updateEmp(@RequestBody Employee employee) {
		int id = employeeService.updateEmployee(employee);
		return String.format("employee is updated for id::%d",id);
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		String response = employeeService.deleteEmployeeById(id);
		return response;
	}
	
	@GetMapping("/allEmp/{page}")
	public List<Employee> getEmployeeByPage(@PathVariable int page){
		return employeeService.getAllEmployeeByPage(page,2);
		
	}
	
	@GetMapping("/allEmp/sort")
	public List<Employee> getAllBySorting(){
		return employeeService.getAllEmployeeBySorting();
		
	}
	
	@GetMapping("/findEmpByCity/{city}")
	public List<Employee> findByCity(@PathVariable String city){
	List<Employee> findByCity = employeeService.findByCity(city);
	return findByCity;
		
	}
	
	@GetMapping("findByNameAndCity/{name}/{city}")
	public Employee findByNameAndCity(@PathVariable String name,@PathVariable String city) {
		Employee findByNameAndCity = employeeService.findByNameAndCity(name, city);
		return findByNameAndCity;
	}
	
}
