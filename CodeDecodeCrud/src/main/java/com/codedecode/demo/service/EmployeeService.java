package com.codedecode.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.demo.custom.exception.BusinessException;
import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.repos.EmployeeCrudRepo;

@Service
// We can use here @ Component as well its a fancy thing to explain this it is a service readable code


public class EmployeeService implements EmployeeServiceInterface{

	
	@Autowired
	private EmployeeCrudRepo crudRepo;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		try {
			if(employee.getName().isEmpty() ||employee.getName().length()==0) {
				throw new BusinessException( "601","Please send Proper Name");
			}
			Employee savedEmployee=crudRepo.save(employee);
			return savedEmployee;
		}catch(IllegalArgumentException e) {
			throw new BusinessException("602","Given Employee is Null"+e.getMessage());
		}
		catch(Exception e) {
			throw new BusinessException("603","Something get Wrong in Service Layer"+e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
		
	}

	@Override
	public Employee getEmpById(Long empidL) {
		return crudRepo.findById(empidL).get();
		
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
		
	}
}
