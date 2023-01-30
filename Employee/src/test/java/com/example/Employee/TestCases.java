package com.example.Employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;

public class TestCases extends EmployeeApplicationTests{
    @Autowired
	private EmployeeRepository emprepo;
    
    @Test
	public void testCreate() {
		Employee emp = new Employee();
		
		emp.setDateofbirth("04/04/1997");
		emp.setEdept(20);
		emp.setEname("yashika");
		emp.setEsal(40000);
		this.emprepo.save(emp);
		assertNotNull(this.emprepo.findById(emp.getId()).get());
	}
    @Test
    public void testReadAll() {
    List<Employee> emp = 	this.emprepo.findAll();
    assertThat(emp).size().isGreaterThan(0);
    }
    @Test
    public void testSingleProduct() {
    	Employee emp = this.emprepo.findById(52).get();
    	assertEquals(17000, emp.getEsal());
    }
    @Test
    public void testUpdate() {
    	Employee emp = this.emprepo.findById(2).get();
    	emp.setEname("priyanka");
    	this.emprepo.save(emp);
    	assertNotEquals("kartika",this.emprepo.findById(2).get().getEname());
    }
    @Test
    public void testDelete() {
    	Employee emp = this.emprepo.findById(2).get();
    	emp.setDeleted(true);
    	this.emprepo.save(emp);
    	assertEquals(true,this.emprepo.findById(2).get().isDeleted());
    }
}
