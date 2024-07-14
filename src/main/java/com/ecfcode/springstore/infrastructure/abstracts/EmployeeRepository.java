package com.ecfcode.springstore.infrastructure.abstracts;

import com.ecfcode.springstore.infrastructure.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByReportsTo(Integer reportsTo);
	
	
	
}
