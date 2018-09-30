package src.main.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import src.main.model.Product;
import src.main.model.Seller;

public class SellerDAO {

	public Seller getSeller(int id) {

		Seller Seller = new Seller();

		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Seller where ID='" + id + "'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();

			Seller.setName(resultSet.getString("Name"));
			Seller.setProducts(getProductsBySellerId(id));
			
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

		return Seller;
	}

	private List<Product> getProductsBySellerId(int id) {
		ProductDAO pdao = new ProductDAO();
		List<Product> products = new ArrayList<Product>();
		for (Iterator<Product> it = pdao.getAllProducts().iterator(); it.hasNext(); ) {
			Product p = it.next();
			if (p.getSellerId() == id) {
				products.add(p);
			}			
		}
		return products;
	}

	public Set<Seller> getAllSellers() {

		Connection connection = DBConnection.getDatabaseConnection();
		Set<Seller> Sellers = new HashSet<Seller>();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Seller";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int SellerId = Integer.parseInt(resultSet.getString("ID"));
				Seller Seller = getSeller(SellerId);
				if (Seller != null) {
					Sellers.add(Seller);
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

		return Sellers;
	}

	public Seller addSeller(String name) {

		Seller Seller = new Seller();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);

		Seller.setName(name);
		Seller.setID(randomInt);

		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO Seller (ID,Name)" + "VALUES(" + Seller.getID() + ",'" + Seller.getName()
					+ "')";
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

		return Seller;
	}

	public void updateSeller(String name, int id) {
		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Seller SET Name='"+ name + "' WHERE ID='" + id + "')";
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

	public void deleteSeller(int id) {

		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();

			String deleteQuery = "DELETE FROM Seller WHERE ID='" + id + "')";
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
