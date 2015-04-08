package demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select x from Customer x order by x.firstName, x.lastName")
	List<Customer> findAllOrderByName();
}
