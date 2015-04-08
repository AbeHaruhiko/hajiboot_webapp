package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Customer;
import demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	// public Customer save(Customer customer) {
	// return customerRepository.save(customer);
	// }

	public List<Customer> findAll() {
		return customerRepository.findAllOrderByName();
	}

	public Customer findOne(Integer id) {
		return customerRepository.findOne(id);
	}

	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	public void delete(Integer id) {
		customerRepository.delete(id);
	}
}
