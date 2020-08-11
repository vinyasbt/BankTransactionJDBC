package bean;

import dao.Dao;
import dao.DaoImpl;

public class Account {
	Dao dao=new DaoImpl();
	private String accountid;
	private String accountname;
	private String address;
	private Double depositAmount;

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Account getDetails(String accountId) {
		return(dao.getDetails(accountId));
	}

	public void showDetails(String accountId) {
		Account demo=new Account();
		demo.getDetails(accountId);

	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountname=" + accountname + ", address=" + address
				+ ", depositAmount=" + depositAmount + "]";
	}

}
