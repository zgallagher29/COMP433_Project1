package src.main.manage;

import src.main.dal.*;
import java.util.Set;
import src.main.model.Seller;

public class SellerManager {
	
	private static SellerDAO dao = new SellerDAO();
	
	public Set<Seller> getAllSellers(){
		return dao.getAllSellers();
	}
	
	public Seller getSeller(int id) {
		return dao.getSeller(id);
	}
	
	public Seller addSeller(String name) {
		
		Seller seller = dao.addSeller(name);
		
		return seller;
	}

	public void updateSeller() {
		dao.updateSeller();
	}

	public void deleteSeller(int id) {
		dao.deleteSeller(id);
	}
}
