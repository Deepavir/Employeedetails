package com.example.Employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	List<Employee> findByDeleted(boolean deleted);
	
}
