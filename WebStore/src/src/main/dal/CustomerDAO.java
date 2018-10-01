package src.main.dal;

import java.sql.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import src.main.model.Address;
import src.main.model.BillingInformation;
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

			customer.setId(id);
			customer.setPhoneNumber(resultSet.getString("PhoneNumber"));
			customer.setLastName(resultSet.getString("LastName"));
			customer.setFirstName(resultSet.getString("FirstName"));		
			customer.setAddress(getAddressByCustId(id));
			customer.setBillingInformation(getBillingInfoByCustId(id));
			
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

	private BillingInformation getBillingInfoByCustId(int customerId) {
		BillingInformationDAO dao = new BillingInformationDAO();
		for (Iterator<BillingInformation> it = dao.getAllBillingInformations().iterator(); it.hasNext(); ) {
			BillingInformation currentBillingInfo = it.next();
			if (currentBillingInfo.getCustomerId() == customerId) {
				return currentBillingInfo;
			}
		}
		return null;
	}

	private Address getAddressByCustId(int customerId) {
		AddressDAO dao = new AddressDAO();
		for (Iterator<Address> it = dao.getAllAddresses().iterator(); it.hasNext(); ) {
			Address currentAddress = it.next();
			if (currentAddress.getCustomerId() == customerId) {
				return currentAddress;
			}
		}
		return null;
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

	public Customer addCustomer(String firstName, String lastName, String phoneNumber) {

		Customer customer = new Customer(firstName, lastName, phoneNumber);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		customer.setId(randomInt);
	
		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO Customer (ID,FirstName,LastName,PhoneNumber)" + "VALUES(" + customer.getId() + ",'"
					+ customer.getFirstName() + "','" + customer.getLastName() + "', PhoneNumber='" + customer.getPhoneNumber() + "')";
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

	public void updateCustomer(String firstName, String lastName, String phoneNumber, int id) {
		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Customer SET FirstName='"+ firstName + "', LastName='" + lastName +"', PhoneNumber='" + phoneNumber + "' WHERE ID='" + id + "')";
			updateStatement.executeUpdate(updateQuery);		
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
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
