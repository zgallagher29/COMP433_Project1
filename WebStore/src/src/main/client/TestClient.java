package src.main.client;

import java.util.Set;

import src.main.CustomerManager;
import src.main.model.Customer;

public class TestClient {

	public static void main(String args[]) {
		
		CustomerManager manager = new CustomerManager();
		
		//manager.addCustomer("Zac", "Gallagher");
		
		Set<Customer> customers = manager.getAllCustomers();
		
		if (!customers.isEmpty()) {
			System.out.println(customers.iterator().next().getFirstName());
			
		}
		
	}
}
