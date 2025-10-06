package com.example.employee.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
  boolean existsByEmail(String email);
  
  List<Employee> findByNameContainingIgnoreCase(String name);
  
}
