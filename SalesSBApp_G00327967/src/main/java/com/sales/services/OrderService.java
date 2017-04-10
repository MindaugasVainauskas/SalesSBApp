package com.sales.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.models.Order;
import com.sales.repositories.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	private final OrderRepository orderRepo;

	public OrderService(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	public List<Order> listOrders(){
		List<Order> orderList = new ArrayList<>();
		
		for(Order o : orderRepo.findAll()){
			orderList.add(o);
		}
		
		return orderList;
	}
	
	//save new order in the database
	public void addOrder(Order order){
		orderRepo.save(order);
	}

}
