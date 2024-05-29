import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-products',
  standalone: true,
  imports: [FormsModule,CommonModule,HttpClientModule],
  templateUrl: './add-products.component.html',
  styleUrl: './add-products.component.css'
})
export class AddProductsComponent {
  lstOfProducts:any=[]
  backEndUrl:string="http://localhost/8080/"

  constructor(private http:HttpClient){

  }
      
  handleSubmit(ProductForm:NgForm){
    this.http.post("http://localhost:8080/product/insert-product",ProductForm.value)
    .subscribe(
      (Successfull)=>{
       alert("Data Added Successfully")
       this.lstOfProducts
        },
        (Error)=>{
        console.log(Error)
        alert("error Occured")
      }
    )

      
  }


     

}














