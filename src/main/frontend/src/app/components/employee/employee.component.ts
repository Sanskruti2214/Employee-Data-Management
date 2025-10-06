import { Component,OnInit  } from '@angular/core';
import {CommonModule} from '@angular/common';
import { Router } from '@angular/router';
import { Employee } from '../../models/Employee';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-employee',
  imports: [CommonModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})

export class EmployeeComponent implements OnInit {
	employees:Employee[] = 	[];
	
	constructor(private employeeService:EmployeeService,private router:Router){}
	
	  ngOnInit(): void {
	    this.loadEmployees();
	  }

	  loadEmployees(): void {
	    this.employeeService.getEmployees().subscribe({
	      next: (data: Employee[]) => {
	        this.employees = data;
	      },
	      error: (err) => {
	        console.error('Error fetching employees:', err);
	      }
	    });
	  }
	
	  updateEmployee(id:number){
	  	 this.router.navigate(['/employees/edit/',id]);
	  }
	  		
	  deleteEmployee(id:number){
		this.employeeService.deleteEmployee(id).subscribe({
		    next: () => {
		      alert('Employee Deleted Successfully!');
		      // Remove from local array to update UI immediately
		      this.employees = this.employees.filter(emp => emp.id !== id);
			}
		 });
	  }
}
