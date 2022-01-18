package com.example.firstRestApi;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class CustomerController {
	
	private CustomerManager customerManager;
	
	@Autowired
	public CustomerController(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
	
	
	@GetMapping("/customers")
	public Iterable<Customer> getAll() {
		return customerManager.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Optional<Customer> getById(@PathVariable Long id) {
		return customerManager.findById(id);
	}
		
	
	@PostMapping("/customers")
	public Customer add(@RequestBody Customer customer) {
		return customerManager.save(customer);
	}
	
	
	@PutMapping("/customers")
	public Customer update(@RequestBody Customer customer) {
		return customerManager.save(customer);
	}
	
	
	@PutMapping("/customers/{id}")
	public Customer updateById(@RequestBody Customer newCustomer, @PathVariable Long id) {
		
		return customerManager.findById(id)
				.map(customer -> {
					customer.setFirstName(newCustomer.getFirstName());
					customer.setLastName(newCustomer.getLastName());
					customer.setEmail(newCustomer.getEmail());
					return customerManager.save(customer);
				})
				.orElseGet(() -> {
					return customerManager.save(newCustomer);
				});	
	}
	
	
	@PatchMapping("customers/{id}")
	public Optional<Object> updateEmail(@RequestBody Customer newCastomer, @PathVariable Long id ) {
		
		return customerManager.findById(id)
				.map(customer -> {
				customer.setEmail(newCastomer.getEmail());
				return customerManager.save(customer);			
	});
	
		}
	
	
	@DeleteMapping("/customers/{id}")
	public void deleteById(@PathVariable Long id) {
		customerManager.deleteById(id);
	}
	
}
