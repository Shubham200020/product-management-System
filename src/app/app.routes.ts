import { Routes } from '@angular/router';
import { ShowProductsComponent } from './show-products/ShowProductsComponent';
import { AddProductsComponent } from './add-products/add-products.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeShowComponent } from './employee-show/employee-show.component';
import { EmployeeDeleteComponent } from './employee-delete/employee-delete.component';

export const routes: Routes = [
{component:ShowProductsComponent,path:"showProducts"},
{component:AddProductsComponent,path:"addProducts"},
{path:"Details",component:EmployeeComponent},
{path:"employeeshow",component:EmployeeShowComponent},
{path:"employeedelete",component:EmployeeDeleteComponent}


];
