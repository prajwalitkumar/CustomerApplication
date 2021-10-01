package com.deloitte.CustomerApplication.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.CustomerApplication.Customer.Entities.Customer;
import com.deloitte.CustomerApplication.Customer.Service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;

@RestController
@RequestMapping(value = "/api")
/* @RequestMapping(value = "/customer") */
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/postcustomer")
	@ApiOperation(value = "Create customer ", notes = "It create customer by taking ID, NAME , EMAIL, AGE values", response = Contact.class)
	public ResponseEntity<Customer> createCustomer(@ApiParam(value = "It takes ID, NAME , EMAIL, AGE values" , required = true)@RequestBody Customer customer)
	{
		Customer cusData = customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(cusData,HttpStatus.CREATED);
	}
	
	@GetMapping
	@ApiOperation(value = "Display Customer Details ", notes = "It display customer details", response = Contact.class)
	public ResponseEntity<List<Customer>> getCustomer()
	{
		List<Customer> customer = customerService.getCustomer();
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getcustomer/{id}")
	@ApiOperation(value = "Display Customer Details By ID ", notes = "It display customer details by taking customer ID", response = Contact.class)
	public ResponseEntity<Customer> getCustomerById(@ApiParam(value = "It takes Customer ID for displaying customer details" , required = true)@PathVariable Integer id)
	{
		Customer cus= customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(cus,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletecustomer/{id}")
	@ApiOperation(value = "Delete Customer Details ", notes = "It delete customer details by taking customer ID", response = Contact.class)
	public ResponseEntity<String> deleteCustomer(@ApiParam(value = "It takes Customer ID for deleting customer details" , required = true)@PathVariable Integer id)
	{
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	

}
