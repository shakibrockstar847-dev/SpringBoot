package com.dailycodebuffer.Springboot.tutorial.entity;



import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long departmentId;
	
	//If the user dosent enter department name now he would get 400 bad request
	@NotBlank(message = "Please add department name")
	@Length(max = 5, min=1)// It only works with 1)Sting datatype and it checks the number of characters in string
	@Size(min = 5 , max= 7) //Size usually works with 1)Arrays 2)Collection 3)String so for Collection and Array it check the size whereas in string it still check the number of characters
	//@Negative - Works on numeric data type
	//@Positive - Works on numeric data type
	//@PositiveOrZero - Works on numeric data type
	//@NegativeOrZero - Works with the date field 
	//@Future - Works with the date field
	//@FutureOrPresent - Works with the date field
	//@Past - Works with the date field
	//@PastOrPresent - Works with the date field
	private String departmentName;
	
	private String departmentAddress;
	
	private String departmentCode;
	

	public Department() {
		super();
	}

	public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
	}
	
	
	

}
