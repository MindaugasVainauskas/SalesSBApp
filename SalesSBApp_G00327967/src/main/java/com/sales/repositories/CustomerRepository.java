package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sales.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
