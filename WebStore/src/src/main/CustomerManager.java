package src.main;

import src.main.dal.*;
import java.util.Set;
import src.main.model.Customer;

public class CustomerManager {
	
	private static CustomerDAO dao = new CustomerDAO();
	
	public Set<Customer> getAllCustomers(){
		return dao.getAllCustomers();
	}
	
	public Customer getCustomer(int id) {
		return dao.getCustomer(id);
	}
	

	public Customer addCustomer(String firstName, String lastName) {
		
		Customer cust = dao.addCustomer(firstName, lastName);
		
		return cust;
	}

	/**
	public void updateEmployee(String id, long salary) {
		dao.updateEmployee(id, salary);
	}
*/
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
	}
}