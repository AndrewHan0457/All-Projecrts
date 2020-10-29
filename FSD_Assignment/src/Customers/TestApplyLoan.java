package Customers;

import Services.Solicitor;

public class TestApplyLoan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer buyer = new Buyer("buyer");
		Seller seller = new Seller("seller");
		Property p = new Property();
		seller.setProperty(p);
		seller.getProperty().setValue(5000.0);
		buyer.setDeposit(3000.0);
		buyer.pay(buyer, seller);
		Solicitor s =new Solicitor();
		System.out.println(s.recommendLoan(buyer.getAmount()));
	}

}
