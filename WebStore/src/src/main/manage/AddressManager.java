package src.main.manage;

import java.util.Set;

import src.main.dal.AddressDAO;
import src.main.model.Address;

public class AddressManager {
	private static AddressDAO dao = new AddressDAO();
	
	public Set<Address> getAllAddresss(){
		return dao.getAllAddresses();
	}
	
	public Address getAddress(int id) {
		return dao.getAddress(id);
	}
	
	public Address addAddress(String city, String state, String country, String streetName, String streetNameTwo, int zip, int customerId) {
		
		Address address = dao.addAddress(city, state, country, streetName, streetNameTwo, zip, customerId);
		
		return address;
	}

	public void updateAddress() {
		dao.updateAddress();
	}

	public void deleteAddress(int id) {
		dao.deleteAddress(id);
	}
}
