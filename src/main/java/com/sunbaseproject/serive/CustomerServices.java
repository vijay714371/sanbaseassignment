package com.sunbaseproject.serive;

import java.util.List;

import com.sunbaseproject.entity.Customer;



public interface CustomerServices {
	
	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public Customer updateCustomer(Customer customer,int cusId);
	public void deleteCustomer(int cusId);

}
