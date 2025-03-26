package com.ecommerce.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.main.dto.EmployeeDto;
import com.ecommerce.main.model.Employee;
import com.ecommerce.main.service.EmployeeService;
import com.ecommerce.main.serviceimpl.EmployeeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/postEmployee")
	public ResponseEntity<EmployeeDto> saveAdmin(@RequestPart("employeeData") String employee,@RequestPart("imageData") MultipartFile multipartFile){
		EmployeeDto adminDto=employeeService.saveEmployee(employee, multipartFile);
		return new ResponseEntity<>(adminDto,HttpStatus.CREATED);
	}
	
}
