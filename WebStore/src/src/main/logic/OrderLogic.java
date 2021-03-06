package src.main.logic;

import java.util.ArrayList;
import java.util.List;

import src.main.dal.OrderDAO;
import src.main.dal.ProductDAO;
import src.main.model.Order;
import src.main.model.Product;

public class OrderLogic {
	
	private final OrderDAO orderDAO;
	private final ProductDAO productDAO;
	
	public OrderLogic() {		
		this.orderDAO = new OrderDAO();
		this.productDAO = new ProductDAO();
	}
	
	public Order createOrder(String status, String orderDate, int customerId, int productId) {	
		Product product = productDAO.getProduct(productId);		
		product = productDAO.updateProduct(product.getCategory(), product.getName(), product.getQuantity()-1, product.getSellerId(), product.getCost(), product);
		
		return orderDAO.addOrder(status, orderDate, customerId, product.getSellerId(), productId, product.getCost());
	}
	
	public Order updateOrder(double cost, String status, String orderDate, int customerId, int productId, Order order) {
		int sellerId = productDAO.getProduct(productId).getSellerId();
		return orderDAO.updateOrder(cost, status, orderDate, customerId, sellerId, productId, order);
	}
	
	public void cancelOrder(Order order) {
		orderDAO.deleteOrder(order.getID());
	}
	
	public List<Order> getOrders(){
		List<Order> orders = new ArrayList<Order>();
		orders.addAll(orderDAO.getAllOrders());
		return orders;
	}
	
}
