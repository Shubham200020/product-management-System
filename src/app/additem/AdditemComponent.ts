import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';


@Component({
  selector: 'app-additem',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule, HttpClientModule],
  templateUrl: './additem.component.html',
  styleUrl: './additem.component.css'
})
export class AdditemComponent {

  constructor(private http: HttpClient) {
    this.getNo(this.product);
  }
  product: FormGroup = new FormGroup({
    id: new FormControl(null),
    name: new FormControl('', [Validators.required]),
    componyName: new FormControl(''),
    quantity: new FormControl(''),
    price: new FormControl(''),
    
  });
  get getValue(): any {
    return this.product;
  }
  productDete!: FormGroup;
 
  getNo(mydata: FormGroup) {
    this.productDete = new FormGroup({
      id: new FormControl(null),
      buyingPrice: new FormControl(''),
      produ: new FormControl(mydata?.value)
    });  
    
    
  }
}
