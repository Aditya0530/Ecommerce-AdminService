package com.ecommerce.main.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException(String message) {
		
		super(message);
		
     }
}