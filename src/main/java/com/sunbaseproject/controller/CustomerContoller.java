package com.sunbaseproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbaseproject.entity.Customer;
import com.sunbaseproject.serive.CustomerServices;

@RestController
@RequestMapping("/auth/user/customer")
public class CustomerContoller {
	@Autowired
	private CustomerServices customerServices;
	@PostMapping("/")
	public Customer createCustomer(@RequestBody Customer customer){
		Customer createCustomer = this.customerServices.createCustomer(customer);
		return createCustomer;
	}
	@GetMapping("/")
	public List<Customer> getAllCustomer(){
		List<Customer> allCustomer = this.customerServices.getAllCustomer();
		return allCustomer;
	}
	@PostMapping("/{cusId}")
	public Customer updateCustomer(@RequestBody Customer customer,@PathVariable("cusId") int cusId) {
		Customer updateCustomer = this.customerServices.updateCustomer(customer, cusId);
		return updateCustomer;
	}
	@DeleteMapping("/{cusId}")
	public void deleteCustomer(@PathVariable("cusId") int cusId) {
		this.customerServices.deleteCustomer(cusId);
	}

}
