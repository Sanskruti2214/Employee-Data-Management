import { Component , OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import { Employee } from '../../models/Employee';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-edit-employee',
  imports: [CommonModule,FormsModule],
  templateUrl: './edit-employee.component.html',
  styleUrl: './edit-employee.component.css'
})

export class EditEmployeeComponent {
	id!:number;
	employee:Employee={
		id:0,name:'',email:'',position:'',salary:0
	}
	
	constructor(private employeeService:EmployeeService,private route: ActivatedRoute,private router:Router){}
	
	ngOnInit(): void {
	    this.id = Number(this.route.snapshot.paramMap.get('id'));
	    console.log('ID from URL:', this.id);
	 }
	  
	updateEmployeeDetails(employee:Employee){
		this.employeeService.updateEmployeeDetails(this.id,employee).subscribe({
			next:(employee)=>{
				alert(`Employee with id ${employee.id} updated SuccessFully!`);
				this.router.navigate(['/employees']);
			} 
		});
		
	}
			
	
}
