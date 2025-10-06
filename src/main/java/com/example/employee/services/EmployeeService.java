package com.example.employee.services;

import java.util.List;
import com.example.employee.models.Employee;

public interface EmployeeService{
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public Employee updateEmployee(int id,Employee employee);
	
    public List<Employee> searchEmployeesByName(String name);
	
	public Employee addEmployee(Employee employee);
	
	public void deleteEmployee(int id);

}
