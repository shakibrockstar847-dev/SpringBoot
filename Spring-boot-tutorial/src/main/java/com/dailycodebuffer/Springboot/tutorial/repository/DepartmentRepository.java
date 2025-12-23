package com.dailycodebuffer.Springboot.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
	
	public List<Department> findByDepartmentName(String departmentName);
	
	public List<Department> findByDepartmentNameIgnoreCase(String departmentName);
	
	//findDistinctByDepartmentName()  ---To find distinct
	//findByDepartmentNameAndDepartmentId ---And condition also we can apply
	//findByDepartmentNameOrDepartmentId ---OR condition also we can apply
	//findByDepartmentIdLessThan -- to get number less than
	// Similarly we have greaterThan(), greaterthanEqual(),lessThan()..... to
	//FindByDepartmentNameLike --- Like condition
	//FindByDepartmentNameEndingWith --- To check the end string condition
	
	
	//# We can also use JPQL which works very well with the java object and can also use the  native sql query if the query is too complex with the help of @Query annotation
	//# We can pass the value as "?1" --Vimt
	//Eg @Query("Select e from Employee e where LOWER(e.department.name)=LOWER(:deptName)")
	//    List<Employee> findByDepartmentNameIgnoreCase(@Param("deeptName") String deptName);
	
	//V IMPT we can also write native sql query also
	// EG @Query("Select * from Employee", nativeQuery="true")
}
