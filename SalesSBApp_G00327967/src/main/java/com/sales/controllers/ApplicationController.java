package com.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class ApplicationController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	String indexPage(){		
		return "index";
	}
	
	@GetMapping("/showProducts")
	String productsPage(Model model){		
		model.addAttribute("prodList", productService.listProducts());
		return "Products";
	}
	
	@GetMapping("/showCustomers")
	String customersPage(Model model){	
		model.addAttribute("custList", customerService.listCustomers());
		return "customers";
	}
	
	@GetMapping("/showOrders")
	String ordersPage(Model model){	
		model.addAttribute("orderList", orderService.listOrders());
		return "orders";
	}
}
