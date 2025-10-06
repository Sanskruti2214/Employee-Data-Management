import { Routes } from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {EmployeeComponent} from './components/employee/employee.component';
import {AddEmployeeComponent} from './components/add-employee/add-employee.component';
import {EditEmployeeComponent} from './components/edit-employee/edit-employee.component';
import {SearchEmployeeComponent} from './components/search-employee/search-employee.component';
export const routes: Routes = [
	{
		component:HomeComponent,
		path:'home'
	},
	{
		component:EmployeeComponent,
		path:'employees'
	},
	{
		component:AddEmployeeComponent,
		path:'employees/add'
	},
	{
		component:EditEmployeeComponent,
		path:'employees/edit/:id'
	},
	{  
		component:SearchEmployeeComponent,
		path:'employees/search'
	}
	
	
];
