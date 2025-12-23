package com.dailycodebuffer.Springboot.tutorial.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
//#Note VVV IMPT --	we created the @ExceptionHandler because whenever we have a custom exception created and if we directly try to use it i mean we created a class for custom exception
//And Extended the Exception class that is fine, but when this exception is thrown we would get our custom message that is sure and also we would get the unwanted stack trace and other things
//Which actually we dont need, and if you see the predefined exception classes like the "ClassNotFoundException" if you throw it manually you would realize that if only prints message and status code, it is because its response entity and everything has been already configured as it is the predefined exception
//Now as we are defining our new exception we also should do something such that we only get errormessage and http status code and not other unwanted data, so for that we wrote below method	
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception) {
		
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}
	
	
}
