package dphone.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dphone.customer.dao.CustomerRepository;
import dphone.customer.entity.Customer;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository repo;

	public List<Customer> listAll() {
		return repo.findAll();
	}

	public void save(Customer cust) {
		repo.save(cust);
	}

	public Customer get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

}
