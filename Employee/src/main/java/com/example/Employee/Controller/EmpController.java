package com.example.Employee.Controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Service.Myservice;
import com.example.Employee.payloads.Employeedto;

@RestController
public class EmpController {
	
	
	Logger log = LoggerFactory.getLogger(EmpController.class);
	@Autowired
	private Myservice service;
@GetMapping("/")
	public List<Employeedto> getalldata(){
	log.info("list of all data fetchecd");
		return this.service.getAllEmployee();
	}
	@PostMapping("/add")
	public ResponseEntity addNewData(@RequestBody Employeedto empdto) {
		this.service.AllNewEmployee(empdto);
		log.info("new Employee details added");
		return new ResponseEntity(Map.of("message","Employee detail added successfully"),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
public  ResponseEntity getdatabyid(@PathVariable int id) {
		
		Employeedto empdto = this.service.getDataById(id);
		if(empdto !=null) {
			log.info("employee data fetched of {}",id);
			return  ResponseEntity.ok(empdto);
		}
		else {
			log.error("employee detail not found with id:{}",id);
			return new ResponseEntity(Map.of("message","employee not found"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@PutMapping("/update/{id}")
public ResponseEntity updateData(@RequestBody Employeedto em, @PathVariable int id){
			Employeedto empdto1= this.service.updateData(em,id);
			if(empdto1 ==null) {
				log.info("employee detail updated with id :{}",id);
				return new ResponseEntity(Map.of("message","Employee not found"),HttpStatus.BAD_REQUEST);
			}
			else {
				log.error("employee not found");
				return new ResponseEntity(Map.of("message","updated employee"),HttpStatus.OK);
			}
		
		}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity  deleteProduct(@PathVariable int id) {
		boolean b = this.service.deleteData(id);
		if (b) {
			log.info("employee deleted succussfully :{}",id);
		return  new ResponseEntity(Map.of("message","Employee deleted"),HttpStatus.OK);
		}
		else {
			log.error("employee not found");
			return  new ResponseEntity(Map.of("message","employee not found"),HttpStatus.BAD_REQUEST);
		}
		}

}
