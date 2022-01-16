package com.example.firstRestApi;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerManager {

	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerManager(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}
	
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	
	public void deleteById(Long id) {
		customerRepository.deleteById(id);	
	}
	
}
