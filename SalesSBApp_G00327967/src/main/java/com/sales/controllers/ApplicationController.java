package com.sales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	@GetMapping("/")
	String indexPage(){		
		return "index";
	}
	
	@GetMapping("/showProducts")
	String productsPage(){		
		return "Products";
	}
	
	@GetMapping("/showCustomers")
	String customersPage(){		
		return "customers";
	}
	
	@GetMapping("/showOrders")
	String ordersPage(){		
		return "orders";
	}
}
