package src.main.manage;

import java.util.Date;
import java.util.Set;

import src.main.dal.BillingInformationDAO;
import src.main.model.BillingInformation;

public class BillingInformationManager {
	
	private static BillingInformationDAO dao = new BillingInformationDAO();

	public Set<BillingInformation> getAllBillingInformations() {
		return dao.getAllBillingInformations();
	}

	public BillingInformation getBillingInformation(int id) {
		return dao.getBillingInformation(id);
	}

	public BillingInformation addBillingInformation(String cardNumber, int customerId, Date expirationDate, String nameOnCard, int securityCode) {

		BillingInformation BillingInformation = dao.addBillingInformation(cardNumber, customerId, expirationDate, nameOnCard, securityCode);

		return BillingInformation;
	}

	public void updateBillingInformation() {
		dao.updateBillingInformation();
	}

	public void deleteBillingInformation(int id) {
		dao.deleteBillingInformation(id);
	}
	
}
