package src.main.dal;

import java.sql.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import src.main.model.Address;

public class AddressDAO {

	public Address getAddress(int id) {

		Address address = new Address();
		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Address where ID='" + id + "'";

			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();

			address.setID(resultSet.getInt("ID"));
			address.setCity((resultSet.getString("City")));
			address.setCountry((resultSet.getString("Country")));
			address.setState((resultSet.getString("State")));
			address.setStreetName((resultSet.getString("Street")));
			address.setStreetNameTwo(resultSet.getString("StreetTwo"));
			address.setZip(resultSet.getInt("Zip"));
			address.setCustomerId(resultSet.getInt("CustomerId"));

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
		return address;
	}

	public Set<Address> getAllAddresses() {

		Connection connection = DBConnection.getDatabaseConnection();
		Set<Address> addresses = new HashSet<Address>();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Address";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int addressId = Integer.parseInt(resultSet.getString("ID"));
				Address address = getAddress(addressId);
				if (address != null) {
					addresses.add(address);
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

		return addresses;
	}

	public Address addAddress(String city, String state, String country, String streetName, String streetNameTwo,
			int zip, int customerId) {

		Address address = new Address();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);

		address.setID(randomInt);
		address.setCity(city);
		address.setCountry(country);
		address.setState(state);
		address.setStreetName(streetName);
		address.setStreetNameTwo(streetNameTwo);
		address.setZip(zip);
		address.setCustomerId(customerId);

		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO Address (ID,Street,StreetTwo,City,State,Zip,Country,CustomerId)"
					+ "VALUES(" + address.getID() + ",'" + address.getStreetName() + "','" + address.getStreetNameTwo()
					+ "','" + address.getCity() + "','" + address.getState() + "'," + address.getZip() + ",'"
					+ address.getCountry() + "'," + address.getCustomerId() + ")";
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
		return address;
	}

	public Address updateAddress(String city, String state, String country, String streetName, String streetNameTwo,
			int zip, int customerId, int id) {
		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Address SET StreetName='"+ streetName + "', State='" + state + "' CustomerId=" + customerId + ", StreetNameTwo='" + streetNameTwo + "', City='" + city + "', Country='" + country + "', Zip=" + zip + " WHERE ID='" + id + "')";
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
		return new Address(streetName, streetNameTwo, city, country, state, zip, id, customerId);	
	}

	public void deleteAddress(int id) {
		Connection connection = DBConnection.getDatabaseConnection();
		
		try {
			Statement deleteStatement = connection.createStatement();
			String deleteQuery = "DELETE FROM Address WHERE ID='" + id + "')";
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
