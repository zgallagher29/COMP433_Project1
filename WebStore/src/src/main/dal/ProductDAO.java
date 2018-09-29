package src.main.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import src.main.model.Product;

public class ProductDAO {
	
	public Product getProduct(int id) {

		Product Product = new Product();

		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Product where ID='" + id + "'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();

			Product.setID(resultSet.getInt("ID"));
			Product.setCategory(resultSet.getString("Category"));
			Product.setName(resultSet.getString("Name"));
			Product.setQuantity(resultSet.getInt("Quantity"));
			Product.setSellerId(resultSet.getInt("SellerId"));

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

		return Product;
	}

	public Set<Product> getAllProducts() {

		Connection connection = DBConnection.getDatabaseConnection();
		Set<Product> products = new HashSet<Product>();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from Product";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int productId = Integer.parseInt(resultSet.getString("ID"));
				Product product = getProduct(productId);
				if (product != null) {
					products.add(product);
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

		return products;
	}

	public Product addProduct(String category, String name, int quantity, int sellerId) {

		Product product = new Product();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		product.setID(randomInt);
		product.setCategory(category);
		product.setName(name);
		product.setQuantity(quantity);
		product.setSellerId(sellerId);
		
		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO Product (ID,Category,Name,Quantity,SellerId)" + "VALUES(" + product.getID() + ",'"
					+ product.getCategory() + "','" + product.getName() 
					+ "'," + product.getQuantity() + "," + product.getSellerId() + ")";
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

		return product;
	}

	public void updateProduct() {
	}

	public void deleteProduct(int id) {

		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();

			String deleteQuery = "DELETE FROM Product WHERE ID='" + id + "')";
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
