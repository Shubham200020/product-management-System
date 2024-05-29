import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { product } from '../Entity/product';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule,FormsModule,HttpClientModule,ReactiveFormsModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
  lstOfProducts:any=[]
  produ: any;

  constructor(private http:HttpClient){
    this.getProducts()
    
  }
  data:FormGroup =new FormGroup({
    id:new FormControl(null),
    margin:new FormControl(null),
    produ:new FormControl({}),
    expectedProfit:new FormControl(null),
    correntProfit:new FormControl(null),
    grosPrice:new FormControl(null),
    buyingPrice:new FormControl(''),
    corrgrosPrice:new FormControl('')
    
  })
  sub(){
   this.data.setValue({
    id:this.data.get('id')?.value,
    margin:this.data.get('margin')?.value,
    produ:JSON.parse(this.produ),
    grosPrice:this.data.get('grosPrice')?.value,
    expectedProfit:this.data.get('expectedProfit')?.value,
    correntProfit:this.data.get('correntProfit')?.value,
    buyingPrice:this.data.get('buyingPrice')?.value,
    corrgrosPrice:this.data.get('corrgrosPrice')?.value
   })
   this.http.post("http://localhost:8080/product/insert-producr-deteles",this.data.value).subscribe(
    (data) => {
      alert("Insert data")
      this.lstOfProducts = data;
    }, (error) => {
      alert("Error Occured");
    }

  ); 

  }
  getProducts() {
  
    this.http.get("http://localhost:8080/product/get-product").subscribe(
      (data) => {
        this.lstOfProducts = data;
      }, (error) => {
        alert("Error Occured");
      }

    );
  }
}
