package com.dailycodebuffer.Springboot.tutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;

//Below annotation was not working so i commented it bt it is used to test the repository layer and it should have been there in this program
//It basically does everything like saving the data but the data is actually reverted from the databse once the testing is done
//@DataJpaTest
public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	
//Below Test manager should not be commented i commented it bcause i was getting import error	
//To get the data based on the id itself	
//	@Autowired
//	private TestEntityManager entityManager;
	
	@BeforeEach
	void setyp()
	{
		Department department = Department.builder().departmentName("Mechanical Engineering").departmentCode("ME-011").departmentAddress("Mumbai").build();
		
		//Below line should not be commented
		//entityManager.persist(department);
	
	}
	
	@Test
	public void whenFindById_theReturnDepartment() {
		Department department = departmentRepository.findById(1L).get();
		assertEquals(department.getDepartmentName(), "Mechanical Engineering");
	}
	
	
}
