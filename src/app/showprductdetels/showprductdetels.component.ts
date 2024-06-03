import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-showprductdetels',
  standalone: true,
  imports: [HttpClientModule,CommonModule],
  templateUrl: './showprductdetels.component.html',
  styleUrl: './showprductdetels.component.css'
})
export class ShowprductdetelsComponent {
  data:any=[]
  url:string="http://localhost:8080/product/get-product-deteles";
  constructor(private http:HttpClient){
    this.getData()
  }
  getData(){
    this.http.get(this.url).subscribe(
      (data)=>{
        this.data=data
      },
      (error)=>{

      }
    )
  }
}
