package bean;

import dao.Dao;
import dao.DaoImpl;

public class Loan extends Account {
	Dao dao=new DaoImpl();
	
	Integer loanId;
	Double loanAmount;
	String loanType;

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Loan getLoan(Loan loan,String accnumber) {
		System.out.println("loan class");
		return(dao.getLoan(loan,accnumber));
	}

	public Loan showLoanDetails(int loanid) {
		return(dao.showLoanDetails(loanid));
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", loanType=" + loanType + "]";
	}
}
