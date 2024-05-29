import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule,FormsModule,HttpClientModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  dataList:any=[]
  constructor(private http: HttpClient){
    this.getDate()
  }


  getDate() {
    this.http.get("http://localhost:8080/product/get-product").subscribe(
      (data) => {
        
        this.dataList = data;
      },
      (eror) => {
       
        console.log(eror);
      }
    );
  }

}
