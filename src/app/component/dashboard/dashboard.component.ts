import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl  } from '@angular/forms';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  empDetail !: FormGroup;
  empObj : Employee = new Employee();
  empList : Employee[] = [];

  constructor(private formbuilder : FormBuilder, private empService : EmployeeService) { }

  ngOnInit(): void {
    this.getAllEmployee();
    this.empDetail = this.formbuilder.group({
      id : [''],
      name : [''],
      email : [''],
      salary : ['']
    }); 
  }

  addEmployee(){
    console.log(this.empDetail);
    this.empObj.id = this.empDetail.value.id;
    this.empObj.name = this.empDetail.value.name;
    this.empObj.email = this.empDetail.value.email;
    this.empObj.salary = this.empDetail.value.salary;

    this.empService.addEmployee(this.empObj).subscribe(res=>{
      console.log(res);
      alert("Employee details added successfully");
      this.getAllEmployee();
    },err=>{
      console.log(err);
    });
  }

  getAllEmployee(){
    this.empService.getAllEmployee().subscribe(res=>{
      this.empList = res;
    },err=>{
      console.log("Error while fetching the data");
    });
  }

  editEmployee(emp : Employee){
    this.empDetail.controls['id'].setValue(emp.id);
    this.empDetail.controls['name'].setValue(emp.name);
    this.empDetail.controls['email'].setValue(emp.email);
    this.empDetail.controls['salary'].setValue(emp.salary);
  }

  updateEmployee(){
    this.empObj.id = this.empDetail.value.id;
    this.empObj.name = this.empDetail.value.name;
    this.empObj.email = this.empDetail.value.email;
    this.empObj.salary = this.empDetail.value.salary;

    this.empService.updateEmployee(this.empObj).subscribe(res=>{
      console.log(res);
      alert("Employee details updated successfully");
      this.getAllEmployee();
    },err=>{
      console.log(err);
    });
  }

  deleteEmployee(emp: Employee){
    this.empService.deleteEmployee(emp).subscribe(res=>{
      console.log(res);
      alert("Employee details deleted successfully");
      this.getAllEmployee();
    },err=>{
      console.log(err);
    });
  }

}
