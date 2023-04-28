package com.codedecode.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codedecode.demo.entity.Employee;

@Repository
public interface EmployeeCrudRepo  extends JpaRepository<Employee,Long>{

	
	
	List<Employee> findByName(String name);
	
	List<Employee> findByNameLike(String name);
}
