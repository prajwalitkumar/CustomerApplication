package com.deloitte.CustomerApplication.Customer;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.any;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.deloitte.CustomerApplication.Customer.Controller.CustomerController;
import com.deloitte.CustomerApplication.Customer.Entities.Customer;
import com.deloitte.CustomerApplication.Customer.Service.CustomerService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
class CustomerApplicationTests {
	
	@InjectMocks
    private CustomerController controller;

    @Mock
    private CustomerService service;

	 @Test
     public void createCustomerControllerTest() {
		 Customer customer = new Customer();
		 customer.setName("Prajwalit");
		 when(this.service.createCustomer(any(Customer.class))).thenReturn(customer);
		ResponseEntity<Customer>customer2=this.controller.createCustomer(customer);
		assertEquals(201,customer2.getStatusCodeValue());
	 }
	 
	 @Test
     public void getCustomerControllerTest() {
		Customer customer = new Customer();
		List<Customer>customerList=new ArrayList<Customer>();
		customerList.add(customer);
		
		 when(this.service.getCustomer()).thenReturn(customerList);
		 ResponseEntity<List<Customer>>customer2=this.controller.getCustomer();
		 assertEquals(200,customer2.getStatusCodeValue());
		
	 }
	 
	 @Test
     public void getCustomerByIdControllerTest() {
		 Customer customer = new Customer();
		 when(this.service.getCustomerById(ArgumentMatchers.anyInt())).thenReturn(customer);
		 ResponseEntity<Customer>customer2=this.controller.getCustomerById(1);
			assertEquals(200,customer2.getStatusCodeValue());
		
	 }
	 
	 @Test
     public void deleteCustomerControllerTest() {
		 this.service.deleteCustomer(1);
		 ResponseEntity<String>customer2=this.controller.deleteCustomer(1);
			assertEquals(200,customer2.getStatusCodeValue());
		
	 }
}
	 
	 
