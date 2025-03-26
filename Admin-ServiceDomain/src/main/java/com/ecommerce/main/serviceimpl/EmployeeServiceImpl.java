package com.ecommerce.main.serviceimpl;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.main.dto.EmployeeDto;
import com.ecommerce.main.enums.InventoryRole;
import com.ecommerce.main.exceptions.ImageNotUpdateException;
import com.ecommerce.main.exceptions.FileNotSavedException;
import com.ecommerce.main.model.Employee;
import com.ecommerce.main.repository.EmployeeRepository;
import com.ecommerce.main.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public EmployeeDto saveEmployee(String json,MultipartFile multipartFile) {
		
		Employee employee=null;
		
		try {
			employee =objectMapper.readValue(json, Employee.class);
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		if ("admin".equalsIgnoreCase(employee.getRole())) {
		    employee.setInventoryRole(InventoryRole.ADMIN);  
		} else if ("delivery".equalsIgnoreCase(employee.getRole())) {
			employee.setInventoryRole(InventoryRole.ORDERDELIVERY_HEAD);  
		} else if ("crm".equalsIgnoreCase(employee.getRole())) {
			employee.setInventoryRole(InventoryRole.CRM);  
		} else if ("account".equalsIgnoreCase(employee.getRole())) {
			employee.setInventoryRole(InventoryRole.ACCOUNT_HEAD);  
		} else if ("employee".equalsIgnoreCase(employee.getRole())) {
			employee.setInventoryRole(InventoryRole.HEAD);
		} else {
		    throw new IllegalArgumentException("Invalid role specified");  
		}
		Random randomNo=new Random();
		String[] namePart=employee.getName().split(" ");
		String firstName = namePart[0]; 
		String generateduserName=firstName.toLowerCase()+randomNo.nextInt(1000);
		String passWord=firstName.toLowerCase()+"@"+randomNo.nextInt(1000);	
		
		if(multipartFile.isEmpty()) {
			throw new FileNotSavedException("File Not Be Empty");
		}
		
		if(multipartFile!=null) {
			try {
				employee.setImageFile(multipartFile.getBytes());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		employee.setUsername(generateduserName);
		employee.setPassword(passWord);
		Employee savedAdmin = employeeRepository.save(employee);
		return new EmployeeDto(savedAdmin);
	}

	@Override
	public void updateEmployee(int empId, String employeeJson, MultipartFile multipartFile) {

          Employee employee=null;
          
          try {
  			employee =objectMapper.readValue(employeeJson, Employee.class);
  		}
  		catch(Exception e) {
  				e.printStackTrace();
  				System.out.println(e.getMessage());
  			}
          if(multipartFile.isEmpty()) {
        	  throw new ImageNotUpdateException("Image can't be Empty..");
  		  }
          else {
		try {
			Date date=new Date(System.currentTimeMillis());
			Time time=new Time(System.currentTimeMillis());
		employeeRepository.updateData(employee.getName(),employee.getUsername(),employee.getEmail(),employee.getPassword(),
				employee.getInventoryRole(),employee.getRole(),employee.getPhoneNumber(),date,time,multipartFile.getBytes(),empId);

		}
		catch (IOException e) {
			e.printStackTrace();
           System.out.println(e.getMessage());
		}	
          }		
	}

	
}
