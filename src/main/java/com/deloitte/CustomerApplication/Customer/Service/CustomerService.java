package com.deloitte.CustomerApplication.Customer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.CustomerApplication.Customer.Entities.Customer;
import com.deloitte.CustomerApplication.Customer.Repository.CustomerModel;
import com.deloitte.CustomerApplication.Customer.Repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer)
	{
		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customer, customerModel);
		customerModel = customerRepository.save(customerModel);
		Customer customerData = new Customer();
		BeanUtils.copyProperties(customerModel, customerData);
		return customerData;
		
		
	}
	
	
	public List<Customer> getCustomer()
	{
		List<CustomerModel> lis = new ArrayList<CustomerModel>();
		customerRepository.findAll().forEach(lis::add);
		
		List<Customer> customerlist = new ArrayList<Customer>();
		for(CustomerModel c :lis)
		{
			Customer cus = new Customer();
			BeanUtils.copyProperties(c, cus);
			customerlist.add(cus);
			
			
		}
		return customerlist;
	}
	
	
	public Customer getCustomerById(Integer Id)
	{
		Optional<CustomerModel> customer = customerRepository.findById(Id);
		Customer Cus = new Customer();
		BeanUtils.copyProperties(customer.get(), Cus);
		return Cus;
		
	}
	
	public void deleteCustomer(Integer Id)
	{
		customerRepository.deleteById(Id);
	}

}
