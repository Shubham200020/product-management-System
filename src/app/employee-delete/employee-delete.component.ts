import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-employee-delete',
  standalone: true,
  imports: [FormsModule,CommonModule,HttpClientModule],
  templateUrl: './employee-delete.component.html',
  styleUrl: './employee-delete.component.css'
})
export class EmployeeDeleteComponent {
  
  data:any=[]
  constructor(private http:HttpClient){
    this.getData()
  }
  getData(){
    this.http.get("http://localhost:8080/find-all").subscribe(
      (data)=>{
        this.data=data
      },
      (Errors)=>{
          console.log(Errors)
      }
    )
  }
  sub(formData:NgForm){
    alert(formData.value.em)
    this.http.get("http://localhost:8080/delete-by-id/"+formData.value.em).subscribe(
    (data)=>{
      alert("Delete success fully")
    }
    ,
    (error)=>
    {
      alert("Error")
    console.log(error)
    }
    )
  }
}
