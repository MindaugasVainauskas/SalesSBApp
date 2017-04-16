package com.sales.controllers;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
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
	
	//-------------------------------- Product related methods -------------------------------------------
	@GetMapping("/showProducts")
	String productsPage(Model model){		
		model.addAttribute("prodList", productService.listProducts());
		return "Products";
	}
	
	@GetMapping("/addProduct")
	public String addProduct(Product product){
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam String pDesc, @RequestParam int qtyInStock){
		
		if(result.hasErrors()){
			return "addProduct";
		}
		
		//make new Product object and set its parameters
		product = new Product();
		product.setpDesc(pDesc);
		product.setQtyInStock(qtyInStock);
		
		//save the new product in the database
		productService.addProduct(product);	
		//return product listing page
		return "redirect:/showProducts";
	}
	
	// --------------------  Customer related methods ------------------------------------------
	@GetMapping("/showCustomers")
	public String customersPage(Model model){	
		model.addAttribute("custList", customerService.listCustomers());
		return "customers";
	}
	
	@GetMapping("/addCustomer")
	public String addCustomer(Customer customer){
		return "addCustomer";
	}
	
	@PostMapping("addCustomer")
	public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult result, @RequestParam String cName){
		if(result.hasErrors()){
			return "addCustomer";
		}
		
		customer = new Customer();
		customer.setcName(cName);
		
		customerService.addCustomer(customer);
		return "redirect:/showCustomers";
	}
	
	//------------------------------------ Order related methods -----------------------------------------
	@GetMapping("/showOrders")
	public String ordersPage(Model model){	
		model.addAttribute("orderList", orderService.listOrders());
		return "orders";
	}
	
	@GetMapping("/addOrder")
	public String addOrder(Order order){
		return "addOrder";
	}
	
	@PostMapping("/addOrder")
	public String addNewOrder(@ModelAttribute("order") @Valid Order order,
			BindingResult result, @RequestParam("cust.cId") Long cId, 
			@RequestParam("prod.pId") Long pId, @RequestParam("qty") int qty, RedirectAttributes rettrib){
		
		if(result.hasErrors()){
			return "addOrder";
		}
		
		try {
			
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			
			String orderDate = date.toString();
			
			
			Product prod = productService.getProductbyId(pId); // get product by Id
			Customer cust = customerService.getCustomerById(cId); // get customer by Id
			
			if(prod == null){
				System.out.print("No such Product: "+pId);
				
			}
			if(cust == null){
				System.out.println("No such Customer: "+cId);
			}
			if(prod.getQtyInStock() < qty){
				System.out.println("Quantity too large: Product stock = "+prod.getQtyInStock());
				
			}
			prod.setQtyInStock(prod.getQtyInStock()-qty); // set new amount in stock
			
			
			
			order = new Order();
			order.setOrderDate(orderDate); // set date to current	
			order.setCust(cust); // Set customer for the order
			order.setProd(prod); //set product for the order
			order.setQty(qty); // set quantity to be ordered
			
			orderService.addOrder(order);
		} catch (NullPointerException e) {
			rettrib.addFlashAttribute("error", e.getMessage());
		}
		
		return "redirect:/showOrders";
	}
	
	//commented out for now 
	//logs user out of the application
		@GetMapping("/logout")
		String logout(HttpServletRequest request, HttpServletResponse response){
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			if(authentication != null){
				new SecurityContextLogoutHandler().logout(request, response, authentication);
			}
			
			return "redirect:/login?logout";
		}
}
 