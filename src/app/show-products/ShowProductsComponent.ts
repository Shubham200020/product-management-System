import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';


@Component({
  selector: 'app-show-products',
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule],
  templateUrl: './show-products.component.html',
  styleUrl: './show-products.component.css'
})
export class ShowProductsComponent {
  productId: any | undefined;
  opt: string = "";
  bool: boolean = false;
  productById: any = [];
  lstOfProducts: any = [];
 
  constructor(private http: HttpClient) {
    this.getProducts()
  }

  handleSubmit(ProductForm: NgForm) {
    if (ProductForm.value.opt == "id") {
      this.bool = false;
      this.productId = ProductForm.value.productId;
      this.getById();
    }
    else if (ProductForm.value.opt == "name") {
      this.bool = false;
      this.productId = ProductForm.value.productId;
      this.getByName();
    }
    else if (ProductForm.value.opt == "componyname") {
      this.bool = false;
      this.productId = ProductForm.value.productId;
      this.getByComName();
    }
  }
  butt(data: any) {
   var a; 
   a=prompt("Enter Number Of Quantity Buy");
   this.http.get("http://localhost:8080/product/add-quantity/"+data.id+"/"+a).subscribe(
    (data) => {
      this.lstOfProducts = data;
      alert("Update Quantity")
    }, (error) => {
      alert("Error Occured");
    }

  );
   

  }
  sell(data: any) {
    var a; 
    a=prompt("Enter Number Of Quantity Shell");
    this.http.get("http://localhost:8080/product/sell-quantity/"+data.id+"/"+a).subscribe(
     (data) => {
       this.lstOfProducts = data;
       alert("Update Quantity")
     }, (error) => {
       alert("Error Occured");
     }
 
   );
    
 
   }

  getProducts() {
    this.bool = !this.bool;
    this.http.get("http://localhost:8080/product/get-product").subscribe(
      (data) => {
        this.lstOfProducts = data;
      }, (error) => {
        alert("Error Occured");
      }

    );
  }
  getById() {

    this.http.get("http://localhost:8080/product/search-by-Id/" + this.productId).subscribe(
      (data) => {
        this.productById = data;
        console.log(data);
      }, (error) => {
        alert("Error Occured");
      }

    );
  }
  getByName() {

    this.http.get("http://localhost:8080/product/search-by-name/" + this.productId).subscribe(
      (data) => {
        this.productById = data;
        console.log(data);
      }, (error) => {
        alert("Error Occured");
      }

    );
  }
  getByComName() {

    this.http.get("http://localhost:8080/product/search-by-comname/" + this.productId).subscribe(
      (data) => {
        this.productById = data;
        console.log(data);
      }, (error) => {
        alert("Error Occured");
      }

    );
  }



}
