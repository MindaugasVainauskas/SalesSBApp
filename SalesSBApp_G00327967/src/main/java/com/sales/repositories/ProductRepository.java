package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sales.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
