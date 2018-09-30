package src.main.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.main.dal.ProductDAO;
import src.main.dal.SellerDAO;
import src.main.model.Product;
import src.main.model.Seller;

public class SellerLogic {
	private final SellerDAO sellerDAO;
	private final ProductDAO productDAO;

	public SellerLogic() {
		this.sellerDAO = new SellerDAO();
		this.productDAO = new ProductDAO();
	}

	public Seller addSeller(String name) {
		return sellerDAO.addSeller(name);
	}

	public void removeSeller(int id) {
		sellerDAO.deleteSeller(id);
	}

	public List<Seller> getSellers() {
		List<Seller> sellers = new ArrayList<Seller>();
		sellers.addAll(sellerDAO.getAllSellers());
		return sellers;
	}

	public void updateSeller(String name, int id) {
		sellerDAO.updateSeller(name, id);
	}

	public Seller addSellerProducts(Seller seller, List<Product> products) {
		List<Product> addedProducts = new ArrayList<Product>();
		for (Product p : products) {
			Product added = productDAO.addProduct(p.getCategory(), p.getName(), p.getQuantity(), seller.getID());
			addedProducts.add(added);
		}
		seller.setProducts(addedProducts);
		return seller;
	}

	public Seller updateSellerProducts(Seller seller, List<Product> products) {

		List<Product> currentSellerProducts = getCurrentSellerProducts(seller);

		/** Remove product from DB if its no longer in the seller's list of products */
		for (Product p : currentSellerProducts) {
			if (!products.contains(p)) {
				productDAO.deleteProduct(p.getID());
			}
		}

		/** Vice versa: if the new list has something not in the DB, add new product */
		for (Product p : products) {
			if (!currentSellerProducts.contains(p)) {
				productDAO.addProduct(p.getCategory(), p.getName(), p.getQuantity(), seller.getID());
			}
		}

		/** Update the object's list of current products */
		seller.setProducts(getCurrentSellerProducts(seller));
		return seller;
	}
	
	public void removeSellerProduct(int productId) {
		productDAO.deleteProduct(productId);
	}

	public List<Product> getCurrentSellerProducts(Seller seller) {
		/** Get current seller products */
		List<Product> currentSellerProducts = new ArrayList<Product>();
		for (Iterator<Product> it = productDAO.getAllProducts().iterator(); it.hasNext();) {
			Product p = it.next();
			if (p.getSellerId() == seller.getID()) {
				currentSellerProducts.add(p);
			}
		}

		return currentSellerProducts;
	}
}
