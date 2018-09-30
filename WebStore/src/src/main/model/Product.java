package src.main.model;

public class Product {
	
	int ID;
	String category;
	String name;
	int quantity;
	int sellerId;
	
	public void print() {
		System.out.println("\nProduct Name: " + this.name);
		System.out.println("Category: " + this.category);
		System.out.println("Quantity: " + this.quantity);
		System.out.println("Seller ID: " + this.sellerId);
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
}
