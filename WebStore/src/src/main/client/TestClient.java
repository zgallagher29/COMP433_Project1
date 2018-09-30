package src.main.client;

import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

import src.main.manage.*;
import src.main.model.*;
import src.main.model.Customer;

public class TestClient {

	public static void main(String args[]) {
		
		CustomerManager c = new CustomerManager();
		Set<Customer> customers = c.getAllCustomers();
		
		OrderManager om = new OrderManager();
		Set<Order> orders = om.getAllOrders();
		
		if (!orders.isEmpty()) {
			for (Iterator<Order> it = orders.iterator(); it.hasNext(); ) {
				Order order = it.next();
				order.print();
			}
			
		}		
	}
}
