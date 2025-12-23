package com.dailycodebuffer.Springboot.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	//Without this @RequestBody we had to use jackson jar to convert json data to java object but now it is done automatically by @RequestBody annotation
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
	
	return departmentService.saveDepartment(department);
		
	}
	
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
	
	return departmentService.fetchDepartmentList();
		
	}
	
	@GetMapping("/departments/{id}")
	public Department findById(@PathVariable("id") Long departmentId) {
		
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
