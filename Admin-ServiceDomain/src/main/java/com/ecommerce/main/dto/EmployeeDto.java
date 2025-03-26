package com.ecommerce.main.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.ecommerce.main.enums.InventoryRole;
import com.ecommerce.main.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private int empId;
	private String name;
	private String username;
	private InventoryRole inventoryRole;
	private Date createDate; // Stores the current date (yyyy-MM-dd)
	private Time createTime;

	public EmployeeDto(Employee employee) {
		this.empId = employee.getEmpId();
		this.name = employee.getName();
		this.username = employee.getUsername();
		this.inventoryRole = employee.getInventoryRole();
		this.createDate = employee.getCreateDate();
		this.createTime = employee.getCreateTime();
	}
}
