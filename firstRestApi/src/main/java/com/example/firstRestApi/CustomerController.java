package com.example.firstRestApi;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerManager customerManager;
	
	@Autowired
	public CustomerController(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
	
	
	@GetMapping("/getAll")
	public Iterable<Customer> getAll() {
		return customerManager.findAll();
	}
	
	@GetMapping("/getCustomer")
	public Optional<Customer> getById(@RequestParam Long id) {
		return customerManager.findById(id);
	}
	
	
	@PostMapping("/add1")
	public Customer add(@RequestParam String firstName, @RequestParam String lastName,
		@RequestParam String email) {
		
		Customer customer= new Customer();
		
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);

		return customerManager.save(customer);
	}
	
	
	@PostMapping("/add2")
	public Customer add(@RequestBody Customer customer) {
		return customerManager.save(customer);
	}
	
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam Long id) {
		customerManager.deleteById(id);
	}
	
}
