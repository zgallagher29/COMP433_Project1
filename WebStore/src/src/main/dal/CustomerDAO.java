package src.main.dal;

import java.sql.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import src.main.model.Customer;

public class CustomerDAO {

	public Customer getCustomer(int id) {

		Customer customer = new Customer();

		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Customer where ID='" + id + "'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();

			customer.setLastName(resultSet.getString("lastName"));
			customer.setFirstName(resultSet.getString("firstName"));

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

		return customer;
	}

	public Set<Customer> getAllCustomers() {

		Connection connection = DBConnection.getDatabaseConnection();
		Set<Customer> customers = new HashSet<Customer>();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Customer";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int customerId = Integer.parseInt(resultSet.getString("ID"));
				Customer customer = getCustomer(customerId);
				if (customer != null) {
					customers.add(customer);
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

		return customers;
	}

	public Customer addCustomer(String firstName, String lastName) {

		Customer customer = new Customer();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		customer.setId(randomInt);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		
		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO Customer (ID,firstName,lastName)" + "VALUES(" + customer.getId() + ",'"
					+ customer.getFirstName() + "','" + customer.getLastName() + "')";
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

		return customer;
	}

	public void updateCustomer() {
	}

	public void deleteCustomer(int id) {

		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();

			String deleteQuery = "DELETE FROM Customer WHERE ID='" + id + "')";
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
