package com.ecommerce.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
