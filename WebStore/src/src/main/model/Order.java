package src.main.model;

public class Order {
	int ID;
	Customer customer;
	Seller seller;
	Product product;
	String orderDate;
	String status;
	double cost;
	
	public Order() {}
	
	public Order(int ID, Customer customer, Seller seller, Product product, String orderDate, String status, double cost) {
		this.ID = ID;
		this.customer = customer;
		this.seller = seller;
		this.product = product;
		this.orderDate = orderDate;
		this.status = status;
		this.cost = cost;
	}


	public void print() {
		
		System.out.println("\nOrder:" + this.ID);
		System.out.println("Order Date: " + this.orderDate.toString());
		System.out.println("Cost: " + this.cost);
		this.customer.print();
		this.product.print();
		
	}
	
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
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
