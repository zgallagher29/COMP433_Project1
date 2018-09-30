package src.main.model;

import java.util.Date;

public class BillingInformation {
	int ID;
	int customerId;
	String cardNumber;
	Date expirationDate;
	int securityCode;
	String nameOnCard;
	
	public BillingInformation() {}
	
	public BillingInformation(int ID, int customerId, String cardNumber, Date expirationDate, int securityCode,
			String nameOnCard) {
		this.ID = ID;
		this.customerId = customerId;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
		this.nameOnCard = nameOnCard;
	}

	public void print() {
		System.out.println("\nName on Card:" + this.nameOnCard);
		System.out.println("Card Number: " + this.cardNumber);
		System.out.println("Expiration Date: " + this.expirationDate);
		System.out.println("Security Code: " + this.securityCode);	
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
}
