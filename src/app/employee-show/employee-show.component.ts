import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-show',
  standalone: true,
  imports: [HttpClientModule,CommonModule,FormsModule],
  templateUrl: './employee-show.component.html',
  styleUrl: './employee-show.component.css'
})

export class EmployeeShowComponent {
  dataList:any=[]
  constructor(private http:HttpClient){
    this.getData()
  }
  getData(){
    this.http.get("http://localhost:8080/find-all").subscribe(
      (data)=>{
        this.dataList=data
      },(error)=>{
        alert("Error")
        console.log(error)
      }
    )
  }
}
