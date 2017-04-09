package com.sales.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	private final CustomerRepository customerRepo;
	
	public CustomerService(CustomerRepository custRepo){
		this.customerRepo = custRepo;
	}
	
	//get list of all customers
		public List<Customer> listCustomers(){
			List<Customer> custList = new ArrayList<>();
			
			//iterate through table contents
			for(Customer c : customerRepo.findAll()){
				//add items to list one by one
				custList.add(c);
			}
			
			//return filled list
			return custList;
		}
		
		//save new customer into database
		public void addCustomer(Customer customer){
			customerRepo.save(customer);
		}
}
