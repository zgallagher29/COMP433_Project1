package src.main.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import src.main.model.*;

public class OrderDAO {
	
	public Order getOrder(int id) {

		Order Order = new Order();

		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Orders where ID='" + id + "'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();

			Order.setID(resultSet.getInt("ID"));
			Order.setOrderDate(resultSet.getDate("OrderDate"));
			
			int custId = resultSet.getInt("CustomerId");
			Order.setCustomer(getCustomerById(custId));
			
			int productId = resultSet.getInt("ProductId");
			Order.setProduct(getProductById(productId));
			
			int sellerId = resultSet.getInt("SellerId");
			Order.setSeller(getSellerById(sellerId));

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}

		return Order;
	}

	private Seller getSellerById(int sellerId) {
		SellerDAO dao = new SellerDAO();
		for (Iterator<Seller> it = dao.getAllSellers().iterator(); it.hasNext(); ) {
			Seller currentSeller = it.next();
			if (currentSeller.getID() == sellerId) {
				return currentSeller;
			}
		}
		return null;
	}

	private Product getProductById(int productId) {
		ProductDAO dao = new ProductDAO();
		for (Iterator<Product> it = dao.getAllProducts().iterator(); it.hasNext(); ) {
			Product currentProduct = it.next();
			if (currentProduct.getID() == productId) {
				return currentProduct;
			}
		}
		return null;
	}

	private Customer getCustomerById(int custId) {
		CustomerDAO dao = new CustomerDAO();
		for (Iterator<Customer> it = dao.getAllCustomers().iterator(); it.hasNext(); ) {
			Customer currentCust = it.next();
			if (currentCust.getId() == custId) {
				return currentCust;
			}
		}
		return null;
	}

	public Set<Order> getAllOrders() {

		Connection connection = DBConnection.getDatabaseConnection();
		Set<Order> orders = new HashSet<Order>();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Orders";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int orderId = Integer.parseInt(resultSet.getString("ID"));
				Order order = getOrder(orderId);
				if (order != null) {
					orders.add(order);
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}

		return orders;
	}

	public Order addOrder(java.util.Date orderDate, int customerId, int sellerId, int productId) {

		Order Order = new Order();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		Order.setID(randomInt);
		Order.setOrderDate(orderDate);
		
		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO Orders (ID,OrderDate,CustomerId,ProductId,SellerId)" + "VALUES(" + Order.getID() + ",'"
					+ Order.getOrderDate() + "'," + customerId 
					+ "," + productId + "," + sellerId + ")";
			insertStatement.executeUpdate(insertQuery);

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}

		return Order;
	}

	public void updateOrder() {
	}

	public void deleteOrder(int id) {

		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();

			String deleteQuery = "DELETE FROM Orders WHERE ID='" + id + "')";
			deleteStatement.executeUpdate(deleteQuery);

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
