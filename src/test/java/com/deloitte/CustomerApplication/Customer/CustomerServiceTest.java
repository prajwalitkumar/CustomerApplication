package com.deloitte.CustomerApplication.Customer;

import static org.junit.jupiter.api.Assertions.assertAll;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.deloitte.CustomerApplication.Customer.Entities.Customer;
import com.deloitte.CustomerApplication.Customer.Repository.CustomerModel;
import com.deloitte.CustomerApplication.Customer.Repository.CustomerRepository;
import com.deloitte.CustomerApplication.Customer.Service.CustomerService;



@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceTest {

       @InjectMocks
       private CustomerService service;

       @Mock
       private CustomerRepository repo;
       

       @Test
       public void createCustomerTest() {

             Customer customer = new Customer();
             customer.setName("Prajwalit");
             customer.setEmail("prajdash@gmail.com");
             customer.setAge(23);
             CustomerModel customerModel = new CustomerModel();
             customerModel.setName("Prajwalit");
             customerModel.setEmail("prajdash@gmail.com");
             customerModel.setAge(23);
       when(this.repo.save(ArgumentMatchers.any())).thenReturn(customerModel);
             Customer customer1 = this.service.createCustomer(customer);
             
             
            assertAll(
            		
            		()-> assertEquals(customer.getName(), customer1.getName()),
            		()-> assertEquals(customer.getEmail(), customer1.getEmail()),
            		()-> assertEquals(customer.getAge(), customer1.getAge())
            		
            		
            		
            		);

       }
       
       
       @Test
       public void getCustomerTest() {

             
       when(this.repo.findAll()).thenReturn(Stream.of(new CustomerModel(1, "Prajwalit", 25, "Prajdash@gmail.com")).collect(Collectors.toList()));
             
       assertEquals(1, this.service.getCustomer().size());
       }
       
       @Test
       public void getCustomerByIdTest() {
    	   
    	   CustomerModel customerModel = new CustomerModel();
           customerModel.setId(1);
           Optional<CustomerModel> optionalCustomerModel = Optional.of(customerModel);

             
       when(this.repo.findById(ArgumentMatchers.any())).thenReturn(optionalCustomerModel);
             
       assertEquals(1, this.service.getCustomerById(1).getId());
       }
       
       @Test
       public void deleteCustomerByIdTest() {

    	   Customer customer = new Customer();
           customer.setName("Prajwalit");
           customer.setEmail("prajdash@gmail.com");
           customer.setAge(23);  
           this.service.deleteCustomer(1);
			/* verify(this.repo, times(1)).deleteById(1); */
           
       
       }
       
       
       

}
