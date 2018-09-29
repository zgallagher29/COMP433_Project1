package src.main.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import src.main.model.Order;

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
			Order.setCustomerId(resultSet.getInt("CustomerId"));
			Order.setProductId(resultSet.getInt("ProductId"));
			Order.setSellerId(resultSet.getInt("SellerId"));

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
		Order.setCustomerId(customerId);
		Order.setSellerId(sellerId);
		Order.setProductId(productId);
		
		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO Orders (ID,OrderDate,CustomerId,ProductId,SellerId)" + "VALUES(" + Order.getID() + ",'"
					+ Order.getOrderDate().toInstant().atZone(ZoneId.of("America/Chicago")).toLocalDate() + "'," + Order.getCustomerId() 
					+ "," + Order.getProductId() + "," + Order.getSellerId() + ")";
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
