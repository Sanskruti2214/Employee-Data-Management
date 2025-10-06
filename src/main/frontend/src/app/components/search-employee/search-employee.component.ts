import { Component,OnInit  } from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../../models/Employee';
import { EmployeeService } from '../../services/employee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-employee',
  imports: [CommonModule,FormsModule],
  templateUrl: './search-employee.component.html',
  styleUrl: './search-employee.component.css'
})


export class SearchEmployeeComponent {
	employees: Employee[] = [];
    searchText: string = '';
	constructor(private employeeService: EmployeeService,private router:Router,private route: ActivatedRoute) {}
	
	searchEmployees(){
		if (this.searchText.trim()) {
		     this.employeeService.getEmployeeByName(this.searchText).subscribe({
				next: (employees) => {  
				        this.employees = employees; // update the component array
				}
			 });
		}
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
