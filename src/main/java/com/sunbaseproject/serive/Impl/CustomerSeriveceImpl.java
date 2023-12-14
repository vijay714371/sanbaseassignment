package com.sunbaseproject.serive.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbaseproject.Repository.CustomerRepo;
import com.sunbaseproject.entity.Customer;
import com.sunbaseproject.serive.CustomerServices;


@Service
public class CustomerSeriveceImpl implements CustomerServices {
    @Autowired
	private CustomerRepo customerRepo;
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer save = this.customerRepo.save(customer);
		return save;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> all = this.customerRepo.findAll();
		return all;
	}

	@Override
	public Customer updateCustomer(Customer customer,int cusId) {
		// TODO Auto-generated method stub
		Customer customer1 = this.customerRepo.findById(cusId).orElseThrow();
		customer1.setFirst_name(customer.getFirst_name());
		customer1.setLast_name(customer.getLast_name());
		customer1.setStreet(customer.getStreet());
		customer1.setAddress(customer.getAddress());
		customer1.setCity(customer.getCity());
		customer1.setState(customer.getState());
		customer1.setEmail(customer.getEmail());
		customer1.setPhone(customer.getPhone());
		Customer save = this.customerRepo.save(customer1);
		return save;
	}

	@Override
	public void deleteCustomer(int cusId) {
		// TODO Auto-generated method stub
		this.customerRepo.deleteById(cusId);
		
	}

}
