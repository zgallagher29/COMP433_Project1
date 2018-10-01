package src.main.model;

public class Customer {

	int id;
	String firstName;
	String lastName;
	String phoneNumber;
	Address address;
	BillingInformation billingInformation;
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public void print() {
		System.out.println("\nCustomer Name: " + this.firstName + " " + this.lastName);		
		this.address.print();
		this.billingInformation.print();
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public BillingInformation getBillingInformation() {
		return billingInformation;
	}
	public void setBillingInformation(BillingInformation billingInformation) {
		this.billingInformation = billingInformation;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
