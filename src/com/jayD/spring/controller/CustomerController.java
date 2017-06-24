package com.jayD.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jayD.spring.dao.ICustomerDao;
import com.jayD.spring.entity.Customer;
import com.jayD.spring.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	//private ICustomerDao customerDao;
	ICustomerService customerService;
	@RequestMapping("/list")
	public String listCustomers(Model theModel){
		
		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer){
		customerService.save(thecustomer);
		return "redirect:/customer/list";
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int custId, Model theModel){
		Customer theCustomer = customerService.getCustomer(custId);
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int custId){
		customerService.deleteCust(custId);
		return "redirect:/customer/list";
	}
}
