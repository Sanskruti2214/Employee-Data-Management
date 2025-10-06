import { Component , ViewChild} from '@angular/core';
import { FormsModule , NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/Employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-employee',
  imports: [CommonModule,FormsModule],
  templateUrl: './add-employee.component.html',
  styleUrl: './add-employee.component.css'
})

export class AddEmployeeComponent {
	employee:Employee={
		id:0,
		name:'',
		email:'',
		position:'',
		salary:0
	};
	
	@ViewChild('empForm') employeeForm!: NgForm;
	
	constructor(private employeeService:EmployeeService,private router:Router){}
	
	createEmployee(){
		this.employeeService.createEmployee(this.employee).subscribe({
			next:(employee) => {
				alert(`Employee with name ${employee.name} added SuccessFully!`);
				this.employeeForm.resetForm();  //resets touched, dirty, values
				this.employee = {id:0,name:'',email:'',position:'',salary:0};
			}
		});
	}
	
	
	
	

}
