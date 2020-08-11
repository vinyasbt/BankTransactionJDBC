package dao;
import java.sql.*;  
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bean.Account;
import bean.Loan;

public class DaoImpl implements Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	Integer result = null;


	@Override
	public Account getDetails(String accountId) {
		Account account=new Account();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank?user=root&password=root");
			pstmt=conn.prepareStatement("select * from account where accid=?");
			pstmt.setString(1, accountId);
			boolean result=pstmt.execute();
			if(result) {
				rs = pstmt.getResultSet();
				
				while (rs.next()) {
					account.setAccountid(rs.getString(1));
					account.setAccountname(rs.getString(2));
					account.setAddress(rs.getString(3));
					account.setDepositAmount(rs.getDouble(4));
				}
				System.out.println(account);
				return account;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public Loan showLoanDetails(int loanid) {
		// TODO Auto-generated method stub
		Loan loan =new Loan();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank?user=root&password=root");
			pstmt=conn.prepareStatement("select * from loan where loanid=?");
			pstmt.setInt(1, loanid);
			boolean result=pstmt.execute();
			if(result) {
				rs = pstmt.getResultSet();
				
				while (rs.next()) {
					loan.setLoanId(rs.getInt(1));
					loan.setLoanAmount(rs.getDouble(2));
					loan.setLoanType(rs.getString(3));
				}
				
				return loan;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	

	@Override
	public Double withdrawAmount(String accountid,Integer amount) {
		try {
			Double s = 0.0;
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank?user=root&password=root");
			pstmt = conn.prepareStatement("select depositamt from account where accid=?");
			pstmt.setString(1, accountid);
			Boolean b = pstmt.execute();
			if (b) {
				rs = pstmt.getResultSet();
				
				while (rs.next()) {
					s = rs.getDouble(1);
				}
			}
			pstmt = conn.prepareStatement("update account set depositamt=? where accid=?");
			pstmt.setDouble(1,s-amount);
			pstmt.setString(2, accountid);
			int result=pstmt.executeUpdate();
			if(result >0) {
				System.out.println("amount deposited successfully");
				return s-amount;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Loan payLoan(Integer loanid,Double loanamount) {
		Double s=0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank?user=root&password=root");
			pstmt=conn.prepareStatement("select loanamt from loan where loanid=?");
			pstmt.setInt(1, loanid);
			boolean result=pstmt.execute();
			if(result) {
				rs = pstmt.getResultSet();
				
				while (rs.next()) {
					s = rs.getDouble(1);
					System.out.println(s);
				}
				pstmt=conn.prepareStatement("update loan set loanamt=? where loanid=?");
				pstmt.setDouble(1, s-loanamount);
				pstmt.setInt(2, loanid);
				int temp=pstmt.executeUpdate();
				if(temp>0) {
					System.out.println("loan paid successfully");
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void createAccount(Account account)  {
		
		String query="insert into account values(?,?,?,?)";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank?user=root&password=root");
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, account.getAccountid());
				pstmt.setString(2, account.getAccountname());
				pstmt.setString(3, account.getAddress());
				pstmt.setDouble(4, account.getDepositAmount());
				int result=pstmt.executeUpdate();
				if(result >0) {
					System.out.println("account created");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	@Override
	public Double depositAmount(String accountid,  Integer amount) {
		try {
			Double s = 0.0;
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank?user=root&password=root");
			pstmt = conn.prepareStatement("select depositamt from account where accid=?");
			pstmt.setString(1, accountid);
			Boolean b = pstmt.execute();
			if (b) {
				rs = pstmt.getResultSet();
				
				while (rs.next()) {
					s = rs.getDouble(1);
				}
			}
			pstmt = conn.prepareStatement("update account set depositamt=? where accid=?");
			pstmt.setDouble(1,s+amount);
			pstmt.setString(2, accountid);
			int result=pstmt.executeUpdate();
			if(result >0) {
				System.out.println("amount deposited successfully");
				return s+amount;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Loan getLoan(Loan loan, String accnumber) {
		String s=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank?user=root&password=root");
			pstmt=conn.prepareStatement("select accid from account where accid=?");
			pstmt.setString(1, accnumber);
			
			boolean result=pstmt.execute();
			if(result) {
				rs = pstmt.getResultSet();
				
				while (rs.next()) {
					s = rs.getString(1);
				}
				if(s.equals(accnumber)) {
				String query="insert into loan values(?,?,?)";
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, loan.getLoanId());
				pstmt.setDouble(2, loan.getLoanAmount());
				pstmt.setString(3, loan.getLoanType());
				int result1=pstmt.executeUpdate();
				if(result1 >0) {
					System.out.println("Loan created");
				}
			}
				else {
					System.out.println("enter proper account id");
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return null;
	}
		
	}




