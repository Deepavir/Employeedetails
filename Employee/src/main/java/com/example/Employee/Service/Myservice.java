package com.example.Employee.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;
import com.example.Employee.payloads.Employeedto;


@Service
public class Myservice {

	@Autowired
	private EmployeeRepository emprepo;
	@Autowired
	private ModelMapper modelmapper;
	
public List<Employeedto> getAllEmployee(){
		 List<Employee> list = new ArrayList<>();
		 Employeedto emdto = new Employeedto();
		this.emprepo.findByDeleted(false).forEach(list::add);
		
		return list.stream().map(this::emptodto).collect(Collectors.toList());
		
	}
	 public void AllNewEmployee(Employeedto empdto) {
		 Employee emp = new Employee();
		 emp.setEsal(empdto.getEsal());
		emp.setEname(empdto.getEname());
		emp.setDateofbirth(empdto.getDateofbirth());
		emp.setEdept(empdto.getEdept());
		this.emprepo.save(emp);
		 
	 }
	 public Employeedto getDataById(int id) {
		 Employee emp = new Employee();
			emp = this.emprepo.getById(id);
			if(emp !=null) {
			if (emp.isDeleted()==false) {
			
			
			return this.emptodto(emp);
			}
			else {
				return null;
			}
			}
			else {
				return null;
			}
	 }
			public boolean deleteData(int id) {
				Employee emp = this.emprepo.getById(id);
				if(emp.isDeleted()==false) {
					emp.setDeleted(true);
					this.emprepo.save(emp);
					
					return true;
				}
				else {
					return false;
				}
			
				
			
	 }
	 public Employeedto updateData(Employeedto em,int id) {
        Employee emp = this.emprepo.getById(id);
		    if(emp !=null) {
				if(emp.isDeleted()==false) {
				 this.emprepo.save(this.dtotoemployee(em));
			
				
			return this.emptodto(this.dtotoemployee(em));
			}
				else {
					return null;
				}
		    }
			else {
				return null;
			}
		
	 }
	 
	 
	 
	public Employee dtotoemployee(Employeedto empdto) {
		
		Employee emp = this.modelmapper.map(empdto, Employee.class);
		return emp;
	}
	public Employeedto emptodto(Employee emp) {
		Employeedto empdto = this.modelmapper.map(emp, Employeedto.class);
		return empdto;
	}
}
