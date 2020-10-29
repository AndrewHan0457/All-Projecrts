package Customers;

import InterfacesAndEnums.LoanType;
import Services.Solicitor;

public class Loan {
	private LoanType type;
	private Double amount;
	private  Buyer buyer;
	private Solicitor solicitor;
	public LoanType getType() {
		return type;
	}
	public void setType(LoanType type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public Solicitor getSolicitor() {
		return solicitor;
	}
	public void setSolicitor(Solicitor solicitor) {
		this.solicitor = solicitor;
	}
	
}
