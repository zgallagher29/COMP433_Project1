package src.main;

import java.util.Set;

import src.main.dal.OrderDAO;
import src.main.model.Order;

public class OrderManager {
	
	private static OrderDAO dao = new OrderDAO();

	public Set<Order> getAllOrders() {
		return dao.getAllOrders();
	}

	public Order getOrder(int id) {
		return dao.getOrder(id);
	}

	public Order addOrder(java.util.Date orderDate, int customerId, int sellerId, int productId) {

		Order Order = dao.addOrder(orderDate, customerId, sellerId, productId);

		return Order;
	}

	public void updateOrder() {
		dao.updateOrder();
	}

	public void deleteOrder(int id) {
		dao.deleteOrder(id);
	}
}
