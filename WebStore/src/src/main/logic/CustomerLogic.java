package src.main.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import src.main.dal.AddressDAO;
import src.main.dal.BillingInformationDAO;
import src.main.dal.CustomerDAO;
import src.main.model.Address;
import src.main.model.BillingInformation;
import src.main.model.Customer;

public class CustomerLogic {
	
	private final CustomerDAO customerDAO;
	private final BillingInformationDAO billingDAO;
	private final AddressDAO addressDAO;
	
	public CustomerLogic() {
		this.customerDAO = new CustomerDAO();
		this.billingDAO = new BillingInformationDAO();
		this.addressDAO = new AddressDAO();
	}
	
	public Customer addCustomer(String firstName, String lastName, String phoneNumber) {
		return customerDAO.addCustomer(firstName, lastName, phoneNumber);
	}
	
	public void removeCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
	
	public List<Customer> getCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		customers.addAll(customerDAO.getAllCustomers());
		return customers;
	}
	
	public void updateCustomer(String firstName, String lastName, String phoneNumber, int id) {
		customerDAO.updateCustomer(firstName,lastName,phoneNumber,id);
	}
	
	public Customer addCustomerAddress(String city, String state, String country, String streetName, String streetNameTwo,
			int zip, Customer customer) {
		Address address = addressDAO.addAddress(city, state, country, streetName, streetNameTwo, zip, customer.getId());
		customer.setAddress(address);
		return customer;
	}

	public Customer updateCustomerAddress(String city, String state, String country, String streetName, String streetNameTwo,
			int zip, Customer customer) {
		Address address = addressDAO.updateAddress(city, state, country, streetName, streetNameTwo, zip, customer.getId(), customer.getAddress().getID());
		customer.setAddress(address);
		return customer;
	}
	
	public void removeCustomerAddress(Customer customer) {
		addressDAO.deleteAddress(customer.getAddress().getID());
	}
	
	public Customer addCustomerBillingInfo(String cardNumber, Customer customer, Date expirationDate, String nameOnCard, int securityCode) {
		BillingInformation billingInfo = billingDAO.addBillingInformation(cardNumber, customer.getId(), expirationDate, nameOnCard, securityCode);
		customer.setBillingInformation(billingInfo);
		return customer;
	}
	
	public Customer updateBillingInformation(String cardNumber, Customer customer, Date expirationDate, String nameOnCard, int securityCode) {	
		BillingInformation billingInfo = billingDAO.updateBillingInformation(cardNumber, customer.getId(), expirationDate, nameOnCard, securityCode, customer.getBillingInformation().getID());
		customer.setBillingInformation(billingInfo);
		return customer;
	}
	
	public void removeCustomerBillingInformation(Customer customer) {
		billingDAO.deleteBillingInformation(customer.getBillingInformation().getID());
	}
	
	public void writeReview(int productId, Customer customer) {
		// TODO: this method
	}
}
