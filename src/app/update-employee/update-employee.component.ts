import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent {

  employee : Employee = new Employee();

constructor(private employeeservice:EmployeeService, private route:ActivatedRoute, private router:Router){}

  id!: number;

ngOnInit():void{
  this.id=this.route.snapshot.params['id'];
  this.employeeservice.getEmployeeById(this.id).subscribe(data=>
    {
      this.employee=data;
    })
}

onSubmit()
  {
      this.employeeservice.updateEmployee(this.id,this.employee).subscribe(data=>
        {
           this.goToEmployeeList();
        })
  }

goToEmployeeList()
{
   this.router.navigate(['/employees']);
}
}
