package com.dailycodebuffer.Springboot.tutorial.error;

public class DepartmentNotFoundException extends Exception{
	
	public DepartmentNotFoundException(String msg)
	{
		super(msg);
	}

}
