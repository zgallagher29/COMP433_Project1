package src.main.dal;

public class DBConfig {
	
	private String username;
	private String password;
	private String databaseURL;
	private String databaseName;
	
	public DBConfig(){
		username="admin";
		password="wspadmin2018";
		databaseURL="jdbc:mysql://webservicesprogramming.c4dunx0x7upy.us-east-2.rds.amazonaws.com:3306";
		databaseName="webservicesprogramming?useSSL=false";
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDatabaseURL() {
		return databaseURL+"/"+getDatabaseName();
	}
	
	public String getDatabaseName() {
		return databaseName;
	}

}

