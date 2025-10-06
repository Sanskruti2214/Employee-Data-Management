package com.example.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employee.models.Employee;
import com.example.employee.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
   
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		Employee saved=employeeService.addEmployee(employee);
		return ResponseEntity.ok(saved);
	}
	
	 @GetMapping("/search")
	 public List<Employee> searchEmployees(@RequestParam String name) {
	     return employeeService.searchEmployeesByName(name);
	 }
	 
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@Valid @RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
