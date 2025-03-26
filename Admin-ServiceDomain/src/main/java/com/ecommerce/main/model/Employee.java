package com.ecommerce.main.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ecommerce.main.enums.InventoryRole;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	private String name;
	private String username;

	private String email;

	private String password;

	@Enumerated(EnumType.STRING)
	private InventoryRole inventoryRole;

	
	private String role; // "admin", "employee", etc.
	
	private String phoneNumber;

	private Date createDate; // Stores the current date (yyyy-MM-dd)
	private Time createTime; // Stores the current time (HH:mm:ss)

	@Lob
	@Column(length = 999999999)
	private byte[] imageFile;
	
	@PreUpdate
	public void onUpdate() {
		this.createDate = new Date(System.currentTimeMillis());
		this.createTime = new Time(System.currentTimeMillis());
	}
	

}
