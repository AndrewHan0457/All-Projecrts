package Customers;

import InterfacesAndEnums.Pay;
import Services.Solicitor;

public class Buyer extends Customer implements Pay{

	private Property [] wishlist;
	private Loan loan;
	public double amount;
	private double deposit;
	
	public Buyer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void applyForLoan() {
		amount = 0; //loan amount to apply
		loan.setType(new Solicitor().recommendLoan(amount));
	}

	@Override
	public void pay(Buyer b, Seller s) {
		// TODO Auto-generated method stub
		amount = s.getProperty().getValue() - b.getDeposit();
	}

	public Property[] getWishlist() {
		return wishlist;
	}

	public void setWishlist(Property[] wishlist) {
		this.wishlist = wishlist;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
}
