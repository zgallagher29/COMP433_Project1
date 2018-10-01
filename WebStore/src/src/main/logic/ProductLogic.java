package src.main.logic;

import java.util.ArrayList;
import java.util.List;

import src.main.dal.ProductDAO;
import src.main.model.Product;

public class ProductLogic {
	private final ProductDAO productDAO;

	public ProductLogic() {	
		this.productDAO = new ProductDAO();
	}
	
	public Product getProductByName(String name) {
		
		List<Product> products = getAllProducts();
		
		for (Product p : products) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
	
		return null;
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		products.addAll(productDAO.getAllProducts());
		return products;
	}
	
}
