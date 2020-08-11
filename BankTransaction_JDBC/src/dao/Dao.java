package dao;

import bean.Account;
import bean.Loan;

public interface Dao {
	Account getDetails(String accountId);
//	void showDetails();
	Loan getLoan(Loan loan,String accnumber);
	Loan showLoanDetails(int loanid);
	Double depositAmount(String accountid,Integer amount);
	Double withdrawAmount(String accountid,Integer amount);
	Loan payLoan(Integer loanid,Double loanamount);
//	void showAccountDetails();
	void createAccount(Account account);
}
