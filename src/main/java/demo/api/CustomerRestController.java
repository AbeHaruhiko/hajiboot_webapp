package demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Customer;
import demo.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;

	// 顧客全件取得
	@RequestMapping(method = RequestMethod.GET)
	List<Customer> getCustomers() {
		List<Customer> customers = customerService.findAll();
		return customers;
	}

	// 顧客一件取得
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	Customer getCustomer(@PathVariable Integer id) {
		Customer customer = customerService.findOne(id);
		return customer;
	}

	// 新規作成
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	Customer postCustomers(@RequestBody Customer customer) {
		return customerService.create(customer);
	}

	// 一件更新
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer);
	}
}
