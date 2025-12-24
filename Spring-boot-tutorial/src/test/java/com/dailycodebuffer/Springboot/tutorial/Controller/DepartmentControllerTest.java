package com.dailycodebuffer.Springboot.tutorial.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dailycodebuffer.Springboot.tutorial.controller.DepartmentController;
import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;

//For testing controller we need to use below @WebMvcTest annotation
@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setup() {
		
		department = Department.builder().departmentName("Mechanical Engineering").departmentCode("ME-011").departmentAddress("Mumbai").departmentId(1L).build();
		
	}
	
	
	
	//Here we would be mocking that we got the request and now we want to send it to the service file
	@Test
	void SaveDepartment() throws Exception {
		Department inputDepartment = Department.builder().departmentName("ITPRA").departmentCode("Comp-06").departmentAddress("Mumbai").build();
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\r\n"
				+ "\"departmentName\":\"ITPRA\",\r\n"
				+ "\"departmentAddress\":\"Mumbai\",\r\n"
				+ "\"departmentCode\":\"Comp-06\"\r\n"
				+ "\r\n"
				+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	void fetchDepartmentById() throws Exception {
		
		Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
		
	}
	
	
}
