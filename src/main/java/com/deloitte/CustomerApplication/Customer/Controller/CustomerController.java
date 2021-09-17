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

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/cus")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		Customer cusData = customerService.CreateCustomer(customer);
		return new ResponseEntity<Customer>(cusData,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getCustomer()
	{
		List<Customer> customer = customerService.getCustomer();
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
	}
	
	@GetMapping(value = "/cus/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id)
	{
		Customer cus= customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(cus,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/cus/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer id)
	{
		customerService.DeleteCustomer(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	

}
