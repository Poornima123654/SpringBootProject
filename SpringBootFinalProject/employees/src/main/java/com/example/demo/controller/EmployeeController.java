package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

	@RestController
	@RequestMapping("/api/v1/")
	public class EmployeeController {

		@Autowired
		private EmployeeRepository employeeRepository;

		
		//Get all students
		@CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/employees")
		public List<Employee> getAllEmployees()
		{
			return employeeRepository.findAll();
			
		}
		//Create student Rest API
		@CrossOrigin(origins="http://localhost:4200")
		@PostMapping("/employees")
		public Employee createEmployee(@RequestBody Employee employee)
		{
			return employeeRepository.save(employee);
			
		}
	
		//get employee by id Rest API
		@CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/employees/{id}")
		public  ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
		{
			Employee employee = employeeRepository.findById(id).
					orElseThrow(()->new ResourceNotFoundException
					("Employee not exist with id:"+id));
			return ResponseEntity.ok(employee);
			
		}
		
	    //Update Employee Rest API
		@CrossOrigin(origins="http://localhost:4200")
		@PutMapping("employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails)
		{
			Employee employee = employeeRepository. findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
					
					
			employee.setFirstname(employeeDetails.getFirstname());
			employee.setLastname(employeeDetails.getLastname());
			employee.setEmailid(employeeDetails.getEmailid());
			employee.setSalary(employeeDetails.getSalary());
			employee.setPhoneno(employeeDetails.getPhoneno());
			
			Employee updatedEmployee=employeeRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
			
		}
		
		
	    // delete employee rest api
		@CrossOrigin(origins="http://localhost:4200")
			@DeleteMapping("/employees/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
				Employee employee =employeeRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
				
				employeeRepository.delete(employee);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

		
}
