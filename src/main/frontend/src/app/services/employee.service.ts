import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError,throwError } from 'rxjs';
import { Employee } from '../models/Employee';

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {
  private readonly apiUrl='http://localhost:8080/api/employees';
  constructor(private http:HttpClient) {}
  
  // Create Employee Record
  createEmployee(employee:Employee):Observable<Employee>{
	return this.http.post<Employee>(this.apiUrl,employee);
  }
  
  // Get All Employees
  getEmployees():Observable<Employee[]>{
	return this.http.get<Employee[]>(this.apiUrl);
  }
  
  // Search for Employee Name
  getEmployeeByName(name:string):Observable<Employee[]>{
	return this.http.get<Employee[]>(`${this.apiUrl}/search`, {
	      params: { name }
	    });
  }
  
  // Update Employee Details
  updateEmployeeDetails(id:number,employee:Employee):Observable<Employee>{
	return this.http.put<Employee>(`${this.apiUrl}/${id}`,employee);
  }
  
  // Delete the Employee
  deleteEmployee(id:number):Observable<void>{
	return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
  
}
