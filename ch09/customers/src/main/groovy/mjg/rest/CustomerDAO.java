package mjg.rest;

import java.util.List;

public interface CustomerDAO {
	List<Customer> findAll();
	Customer findById(long id);
	List<Customer> findByLastName(String name);
	Customer create(Customer c);
	Customer update(Customer c);
	boolean delete(long id);
}
