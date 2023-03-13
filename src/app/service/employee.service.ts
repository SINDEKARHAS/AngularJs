import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  serviceEmpUrl : string;
  addEmpUrl : string;
  getEmpUrl : string;
  updateEmpUrl : string;
  deleteEmpUrl : string;

  constructor(private http : HttpClient) {

    this.serviceEmpUrl = "http://localhost:9091/emp/addEmployee";
    this.addEmpUrl = "http://localhost:9091/emp/addEmployee";
    this.getEmpUrl = "http://localhost:9091/emp/getAllEmployees";
    this.updateEmpUrl = "http://localhost:9091/emp/updateEmployee";
    this.deleteEmpUrl = "http://localhost:9091/emp/deleteEmployeeByID"
   }

   addEmployee(emp : Employee) : Observable<Employee>{
      return this.http.post<Employee>(this.addEmpUrl, emp)
      
   }

   getAllEmployee(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.getEmpUrl);

   }

   updateEmployee(emp : Employee):Observable<Employee>{
    return this.http.put<Employee>(this.updateEmpUrl+'/'+emp.id, emp);
   }

  deleteEmployee(emp : Employee) : Observable<Employee>{
    return this.http.delete<Employee>(this.deleteEmpUrl+'/'+emp.id);
  }
}
