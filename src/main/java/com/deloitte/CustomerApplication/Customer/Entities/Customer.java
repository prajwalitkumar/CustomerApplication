package com.deloitte.CustomerApplication.Customer.Entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the Customer")
public class Customer {
	
	@ApiModelProperty(notes = "Unique ID of Customer")
	private Integer id;
	@ApiModelProperty(notes = "Name of Customer")
	private String name;
	@ApiModelProperty(notes = "Age of Customer")
	private int age;
	@ApiModelProperty(notes = "EmailID of Customer")
	private String email;
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	

	
	
	
	
	

}
