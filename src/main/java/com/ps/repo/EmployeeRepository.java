package com.ps.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
}
