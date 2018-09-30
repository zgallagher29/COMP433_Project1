package src.main.model;

import java.util.List;

public class Seller {
	
	int ID;
	String name;
	List<Product> products;
	
	public void print() {
		System.out.println("\nSeller Name: "+ this.name);
		for (Product p : products) {
			System.out.println("\n--Product--");
			p.print();
		}
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
