package src.main.client;

import java.util.Iterator;
import java.util.Set;

import src.main.dal.OrderDAO;
import src.main.model.*;

public class TestClient {

	public static void main(String args[]) {
		
		OrderDAO om = new OrderDAO();
		Set<Order> orders = om.getAllOrders();
		
		if (!orders.isEmpty()) {
			for (Iterator<Order> it = orders.iterator(); it.hasNext(); ) {
				Order order = it.next();
				order.print();
			}
			
		}		
	}
}
