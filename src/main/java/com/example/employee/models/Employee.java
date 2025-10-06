package com.example.employee.models;
import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false)
	private String position;
	@Column(nullable=false)
	private int salary;

	public Employee() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
