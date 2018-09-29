package src.main.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import src.main.model.BillingInformation;

public class BillingInformationDAO {
	
	public BillingInformation getBillingInformation(int id) {

		BillingInformation BillingInformation = new BillingInformation();

		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from BillingInformation where ID='" + id + "'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();

			BillingInformation.setID(resultSet.getInt("ID"));
			BillingInformation.setCustomerId(resultSet.getInt("CustomerId"));
			BillingInformation.setCardNumber(resultSet.getInt("CreditCardNumber"));
			BillingInformation.setSecurityCode(resultSet.getInt("SecurityCode"));
			BillingInformation.setNameOnCard(resultSet.getString("NameOnCard"));
			BillingInformation.setExpirationDate(resultSet.getDate("ExpirationDate"));

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

		return BillingInformation;
	}

	public Set<BillingInformation> getAllBillingInformations() {

		Connection connection = DBConnection.getDatabaseConnection();
		Set<BillingInformation> BillingInformations = new HashSet<BillingInformation>();

		try {
			Statement selectStatement = connection.createStatement();

			String selectQuery = "SELECT * from BillingInformation";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);

			while (resultSet.next()) {
				int BillingInformationId = Integer.parseInt(resultSet.getString("ID"));
				BillingInformation BillingInformation = getBillingInformation(BillingInformationId);
				if (BillingInformation != null) {
					BillingInformations.add(BillingInformation);
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

		return BillingInformations;
	}

	public BillingInformation addBillingInformation(int cardNumber, int customerId, Date expirationDate, String nameOnCard, int securityCode) {

		BillingInformation BillingInformation = new BillingInformation();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		BillingInformation.setID(randomInt);
		BillingInformation.setCardNumber(cardNumber);
		BillingInformation.setCustomerId(customerId);
		BillingInformation.setExpirationDate(expirationDate);;
		BillingInformation.setNameOnCard(nameOnCard);
		BillingInformation.setSecurityCode(securityCode);
		
		Connection connection = DBConnection.getDatabaseConnection();

		try {
			Statement insertStatement = connection.createStatement();

			String insertQuery = "INSERT INTO BillingInformation (ID,CustomerId,CreditCardNumber,SecurityCode,NameOnCard,ExpirationDate)" + "VALUES(" + BillingInformation.getID() + ","
					+ BillingInformation.getCustomerId() + "," + BillingInformation.getCardNumber() 
					+ "," + BillingInformation.getSecurityCode() + ",'" + BillingInformation.getNameOnCard() + "','" + BillingInformation.getExpirationDate() + "')";
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

		return BillingInformation;
	}

	public void updateBillingInformation() {
	}

	public void deleteBillingInformation(int id) {

		Connection connection = DBConnection.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();

			String deleteQuery = "DELETE FROM BillingInformation WHERE ID='" + id + "')";
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
