import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {


   baseURL = "http://localhost:8080/api/v1/employees"

  constructor(private httpclient:HttpClient) { }

  getEmployeeList():Observable<Employee[]>
  {
    return this.httpclient.get<Employee[]>(`${this.baseURL}`);
  }

   createEmployee(employee: Employee):Observable<Object>
   {
      return this.httpclient.post(`${this.baseURL}`,employee);
   }

   getEmployeeById(id:number):Observable<Employee>
   {
      return this.httpclient.get<Employee>(`${this.baseURL}/${id}`);
   }
    updateEmployee(id:number,employee:Employee):Observable<Object>
    {
      return this.httpclient.put(`${this.baseURL}/${id}`,employee);
    }
    deletEmployee(id:number):Observable<Object>
    {
      return this.httpclient.delete(`${this.baseURL}/${id}`);
    }
}
