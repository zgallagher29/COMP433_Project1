package src.main.manage;

import java.util.Set;

import src.main.dal.ProductDAO;
import src.main.model.Product;

public class ProductManager {
	
	private static ProductDAO dao = new ProductDAO();

	public Set<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	public Product getProduct(int id) {
		return dao.getProduct(id);
	}

	public Product addProduct(String category, String name, int quantity, int sellerId) {

		Product product = dao.addProduct(category, name, quantity, sellerId);

		return product;
	}

	public void updateProduct() {
		dao.updateProduct();
	}

	public void deleteProduct(int id) {
		dao.deleteProduct(id);
	}
}
