import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  constructor(private employeeService: EmployeeService,private route: ActivatedRoute) { }
  id: number;
  employee: Employee;
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee = data;
    }),error => console.log(error);
  }

}
