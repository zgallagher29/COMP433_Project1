package src.main.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import src.main.model.Seller;

public class SellerDAO {
	
	
public Seller getSeller(int id) {
		
		Seller Seller = new Seller();
		
		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Seller where ID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			Seller.setName(resultSet.getString("Name"));
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return Seller;
	}
	
	public Set<Seller> getAllSellers(){
	
		Connection connection = DBConnection.getDatabaseConnection();
		Set<Seller> Sellers = new HashSet<Seller>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Seller";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				int SellerId = Integer.parseInt(resultSet.getString("ID"));
				Seller Seller = getSeller(SellerId);
				if(Seller != null) {
					Sellers.add(Seller);
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
		
		return Sellers;
	}
	
	public Seller addSeller(String name) {
		
		Seller Seller = new Seller();
		Seller.setName(name);
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    Seller.setID(randomInt);
		
		Connection connection = DBConnection.getDatabaseConnection();
		
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO Seller (ID,firstName,lastName)"
					+ "VALUES("+Seller.getID()+",'"+Seller.getName()+"')";
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
		
		return Seller;
	}
	
	public void updateSeller() {}
	
	public void deleteSeller(int id) {
		
		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM Seller WHERE ID='"+id+"')";
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
