package src.main.client;

import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


import src.main.logic.CustomerLogic;
import src.main.logic.OrderLogic;
import src.main.logic.ProductLogic;
import src.main.logic.SellerLogic;
import src.main.model.*;

public class TestClient {

	public static void main(String args[]) throws ParseException {
		
		OrderLogic ologic = new OrderLogic();
		ProductLogic plogic = new ProductLogic();
		CustomerLogic clogic = new CustomerLogic();
		SellerLogic slogic = new SellerLogic();
		
		
		for (Customer c : clogic.getCustomers()) {
			c.print();
		}
		
		for (Order o : ologic.getOrders()) {
			o.print();
		}
	}
}
