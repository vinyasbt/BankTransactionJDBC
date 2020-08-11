package bean;

import dao.Dao;
import dao.DaoImpl;

public class Transaction extends Loan {
	Dao dao = new DaoImpl();
	Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + "]";
	}

	public Double depositAmount(String accountid,Integer amount) {
		return (dao.depositAmount(accountid,amount));
	}

	public Double withdrawAmount(String accountid,Integer amount) {
		return (dao.withdrawAmount(accountid,amount));
	}

	public Loan payLoan(Integer loanid,Double loanamount) {
		return(dao.payLoan(loanid,loanamount));
	}

	public void showAccountDetails() {

	}
}
