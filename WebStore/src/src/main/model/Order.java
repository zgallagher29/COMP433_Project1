package src.main.model;

import java.util.Date;

public class Order {
	int ID;
	Customer customer;
	Seller seller;
	Product product;
	Date orderDate;
	
	public void print() {
		
		System.out.println("\nOrder:" + this.ID);
		System.out.println("Order Date: " + this.orderDate.toString());
		this.customer.print();
		this.product.print();
		
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	
}
