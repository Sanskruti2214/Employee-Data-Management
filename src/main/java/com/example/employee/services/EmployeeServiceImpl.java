package com.example.employee.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.exceptions.DuplicateEmailException;
import com.example.employee.exceptions.EmployeeNotFoundException;
import com.example.employee.models.Employee;
import com.example.employee.repositories.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
    public List<Employee> getAllEmployees(){
    	return employeeRepository.findAll();
    }
	
	public Employee getEmployeeById(int id){
		return employeeRepository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("Employee with id "+id+" Not Found!"));
	}
	
	public Employee addEmployee(Employee employee){
		 if (employeeRepository.existsByEmail(employee.getEmail())) {
		        throw new DuplicateEmailException("Email already exists: " + employee.getEmail());
		  }
		  return employeeRepository.save(employee);
	}
	
	public List<Employee> searchEmployeesByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return employeeRepository.findAll(); // Return all if no keyword
        }
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    
	public Employee updateEmployee(int id,Employee employee) {
		 try {
		        return employeeRepository.findById(id)
		            .map(emp -> {
		                emp.setName(employee.getName());
		                emp.setEmail(employee.getEmail());
		                emp.setPosition(employee.getPosition());
		                emp.setSalary(employee.getSalary());
		                return employeeRepository.save(emp);
		            })
		            .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " Not Found!"));
		    } catch (DataIntegrityViolationException e) {
		        // This will be caught when trying to save a duplicate email
		        throw new DuplicateEmailException("Email already exists: " + employee.getEmail());
		    }
	}
	
	public void deleteEmployee(int id){
		if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id "+id+" Not Found!");
        }
        employeeRepository.deleteById(id);
	}
	
}
