import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURl='http://localhost:8080/api/baghelv1/employees';

  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURl}`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return  this.httpClient.post(`${this.baseURl}`,employee);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURl}/${id}`);
  }

  updateEmployee(id:number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURl}/${id}`,employee);
  }
}
