package com.dailycodebuffer.Springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;



@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
//They are used to clear out the data that we already created
//@AfterAll
//@AfterEach
	
	
//Runs once before all test methods
//Used for expensive or shared setup, like database connections
// So it will run only once then whatever method needs it, it would work, unlike BeforeEach where it is initialised before each @Test method call	
//Executes only once
//Method must be static
//Used for shared resources
// @BeforeAll	
	
	
	@MockitoBean
	private DepartmentRepository departmentRepository;	
	
	
//Runs before every single test method
//Used when each test needs a fresh setup
//Executes once per test
//Helps avoid test interference
//Method must not be static	
	@BeforeEach
	void setup(){
		
		Department department = Department.builder().departmentName("IMGG").departmentAddress("Ahemadabad").departmentCode("IT-06").departmentId(1L).build();
		
		List<Department> lsDepartment = new ArrayList<Department>();
		lsDepartment.add(department);
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IMGG")).thenReturn(lsDepartment);
	}
	
	


	
	//@Disabled To disable any testcase we can use this
	@Test
	//To give our custome name to the test when report is generated
	@DisplayName("Get data based on valid department name")
	public void whenValidDepartmentName_ThenDepartmentShouldBeFound()
	{
		String departmentName = "IMGG";
		List<Department> found = departmentService.fetchDepartmentByName(departmentName);
		assertEquals(departmentName, found.get(0).getDepartmentName());
		
	}
	
}
