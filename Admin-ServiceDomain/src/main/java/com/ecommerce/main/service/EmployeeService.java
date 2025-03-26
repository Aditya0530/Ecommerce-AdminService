package com.ecommerce.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.main.dto.EmployeeDto;
import com.ecommerce.main.model.Employee;

public interface EmployeeService {

public EmployeeDto saveEmployee(String employee,MultipartFile multipartFile);

}
