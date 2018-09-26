package src.main.dal;
import java.sql.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import src.main.model.Address;


public class AddressDAO {
	
	public Address getAddress() {
	Address address = new Address();
	
	Connection connection = DBConnection.getDatabaseConnection();

	try {
		Statement selectStatement = connection.createStatement();
		
		String selectQuery = "SELECT * from Address where ID='" + address.getID() +"'";
		ResultSet resultSet = selectStatement.executeQuery(selectQuery);
		resultSet.next();
		
		address.setCity((resultSet.getString("city")));
		address.setCountry((resultSet.getString("country")));
		address.setState((resultSet.getString("state")));
		address.setStreetName((resultSet.getString("streetName")));
		
		
	}catch(SQLException se) {
		se.printStackTrace();
	}finally {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {}
		}
	}

	return address;
	}
public Set<Address> getAllAddresses(){

	Connection connection = DBConnection.getDatabaseConnection();
	Set<Address> addresses = new HashSet<Address>();
	
	try {
		Statement selectStatement = connection.createStatement();
		
		String selectQuery = "SELECT * from Address";
		ResultSet resultSet = selectStatement.executeQuery(selectQuery);
		
		while(resultSet.next()) {
			int addressId = Integer.parseInt(resultSet.getString("ID"));
			Address address = getAddress();
			if(address != null) {
				addresses.add(address);
			}
		}
		
	}catch(SQLException se) {
		se.printStackTrace();
	}finally {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {}
		}
	}
	
	return addresses;
}

public Address addAddress(String city, String state, String country, String streetName) {
	
	Address address = new Address();
address.setCity(city);
address.setCountry(country);
address.setStreetName(streetName);
	
	Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(10000);
    address.setID(randomInt);
	
	Connection connection = DBConnection.getDatabaseConnection();
	
	try {
		Statement insertStatement = connection.createStatement();
		
		String insertQuery = "INSERT INTO Customer (ID,firstName,lastName)"
				+ "VALUES("+address.getID()+",'"+address.getStreetName()+"','"+address.getCity()+"','"+address.getState()+"')";
		insertStatement.executeUpdate(insertQuery);
				
		
	}catch(SQLException se) {
		se.printStackTrace();
	}finally {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {}
		}
	}
	
	return address;
}

public void updateAddress() {}

public void deleteAddress(int id) {
	
	Connection connection = DBConnection.getDatabaseConnection();
	try {
		Statement deleteStatement = connection.createStatement();
		
		String deleteQuery = "DELETE FROM Customer WHERE ID='"+id+"')";
		deleteStatement.executeUpdate(deleteQuery);	
		
		
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
}


