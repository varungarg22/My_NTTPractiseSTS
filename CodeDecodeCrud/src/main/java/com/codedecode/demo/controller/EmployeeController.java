package com.codedecode.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.repos.EmployeeCrudRepo;
import com.codedecode.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/codev")
public class EmployeeController {

/*	@Autowired
	EmployeeCrudRepo empCrud;
	@GetMapping
	public List<Employee> getAllEmployees(){
		
		System.out.println("Getting All Employees");
		System.out.println("ss"+empCrud.findAll());
		return empCrud.findAll();
	*/
	@Autowired
	private EmployeeServiceInterface empServiceInterface;
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		
		//empServiceInterface.addEmployee(employee);
		Employee employeeSaved= empServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> listOfAllEmployees=empServiceInterface.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfAllEmployees,HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("empid")Long empidL){
		Employee empRetrived =empServiceInterface.getEmpById(empidL);
		return new ResponseEntity<Employee>(empRetrived,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("empid")Long empidL){
		empServiceInterface.deleteEmpById(empidL);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		empServiceInterface.addEmployee(employee);
		Employee employeeSaved= empServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved,HttpStatus.CREATED);
		
	}
	
		
	}

