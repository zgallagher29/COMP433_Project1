package src.main.model;

public class Address {
	String streetName;
	String streetNameTwo;
	String city;
	String country;
	String state;
	int zip;
	int ID;
	int customerId;
	
	public Address() {}
	
	
	public Address(String streetName, String streetNameTwo, String city, String country, String state, int zip, int ID,
			int customerId) {
		this.streetName = streetName;
		this.streetNameTwo = streetNameTwo;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.ID = ID;
		this.customerId = customerId;
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetNameTwo() {
		return streetNameTwo;
	}
	public void setStreetNameTwo(String streetNameTwo) {
		this.streetNameTwo = streetNameTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public void print() {
		System.out.println("\nStreet Name: " + this.streetName);
		System.out.println("Street Name Two: " + this.streetNameTwo);
		System.out.println("City: " + this.city);
		System.out.println("State: " + this.state);
		System.out.println("Zip: " + this.zip);
		System.out.println("Country: " + this.country);
	}
}
