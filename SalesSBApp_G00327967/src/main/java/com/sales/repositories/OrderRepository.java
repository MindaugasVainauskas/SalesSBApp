package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sales.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
