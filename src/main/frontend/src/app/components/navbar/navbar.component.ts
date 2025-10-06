import { Component } from '@angular/core';
import { RouterLink} from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/Employee';
@Component({
  selector: 'app-navbar',
  imports: [RouterLink,CommonModule,FormsModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
	  
}
