package com.dailycodebuffer.Springboot.tutorial.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	//SLF4J is an abstraction layer for logging, while logback is the concreate implementation, we can use different logging implementation if we want by adding the proper dependency
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	
	//Without this @RequestBody we had to use jackson jar to convert json data to java object but now it is done automatically by @RequestBody annotation
	// With the help of below valid annotation we would be able to connect it with the hibernate validation which we have added in our entity
	//So it would be able to check those validation only because of the @Valid
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
	LOGGER.info("Inside saveDepartment() of department controller");
	return departmentService.saveDepartment(department);
		
	}
	
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		LOGGER.info("Inside save ftechdepartmentList() of department controller");	
	return departmentService.fetchDepartmentList();
		
	}
	
	@GetMapping("/departments/{id}")
	public Department findById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		
		return departmentService.fetchDepartmentById(departmentId);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		
		departmentService.deleteDepartmentById(departmentId);
		
		return "Department Deleted Successfully";
				
	}
	
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
	
	return departmentService.saveDepartment(departmentId,department);
		
	}
	
	@GetMapping("/departments/name/{departmentname}")
	public List<Department> fetchDepartmentByName(@PathVariable("departmentname") String departmentname) {
	
	return departmentService.fetchDepartmentByName(departmentname);
		
	}
	
	
	
}
