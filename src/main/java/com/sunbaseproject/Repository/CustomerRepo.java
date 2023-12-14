package com.sunbaseproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbaseproject.entity.Customer;



public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
