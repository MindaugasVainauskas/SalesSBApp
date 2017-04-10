package com.sales.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository pRepo){
		this.productRepo = pRepo;
	}
	
	//get list of all products
	public List<Product> listProducts(){
		List<Product> productList = new ArrayList<>();
		
		//iterate through table contents
		for(Product p : productRepo.findAll()){
			//add items to list one by one
			productList.add(p);
		}
		
		//return filled list
		return productList;
	}
	
	//add new product to the list
	public void addProduct(Product prod){
		productRepo.save(prod);
	}
	
	//get product by ID
	public Product getProductbyId(Long pId){
		return productRepo.findOne(pId);
	}

}
