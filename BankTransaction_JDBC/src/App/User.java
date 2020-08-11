package App;

import java.util.Scanner;

import bean.Account;
import bean.Loan;
import bean.Transaction;
import dao.Dao;
import dao.DaoImpl;
import exception.AccountIDException;
import exception.AccountNameException;
import service.Service;
import service.ServiceImpl;

public class User {

	public static void main(String[] args) {
		Account[] accounts = new Account[10];
		Loan[] loans = new Loan[10];
		Service service = new ServiceImpl();
		Transaction transaction = new Transaction();
		Dao dao=new DaoImpl();
		Scanner sc = new Scanner(System.in);
		String AccountId, AccountName, loanType,LoanAccountId;
		double originalamount,loanAmount = 0.0,finalamount=0.0;
		Integer amount;
		int  a=0,k = 0, loanId=0;
		outerwhile:while (true) {
			System.out.println("Enter your choice: \n 1.Create Account \n 2.Deposit Amount"
					+ " \n 3.Withdraw amount \n 4.Show Account Details\n 5.Apply Loan\n 6.Pay Loan\n 7.Show Loan details"
					+ "\n 8.Exit ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				
				Account account=new Account();
			
				System.out.println("enter your AccountId ex :[1234567-ASDF] ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						account.setAccountid(AccountId);
						break;
					} else
						throw new AccountIDException();
				}

				System.out.println("Enter AccountName : ");
				while (true) {
					AccountName = sc.next();
					if (service.accountNameIsValid(AccountName)) {
						account.setAccountname(AccountName);
						break;
					}else
						throw new AccountNameException();
				}

				System.out.println("Enter Address : ");

				account.setAddress(sc.next());

				System.out.println("Enter deposit Amount : ");

				account.setDepositAmount(sc.nextDouble());
				
				
			accounts[a]=account;
			a++;

				dao.createAccount(account);

				for(Account temp:accounts) {
					if(temp==null)
						break;
					System.out.println(temp);
					
				}

				break;
			}
			case 2: {
				System.out.println("enter your AccountId ex :[1234567-ASDF] ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {

								System.out.println("Enter deposit Amount : ");
								amount = sc.nextInt();
								
								finalamount=transaction.depositAmount(AccountId, amount);
							
							System.out.println("updated balance"+finalamount);
								break;
							}
					 else {
							throw new AccountIDException();
					}

							
						}
						
					
				break;
			}
			
			
			case 3: {
				System.out.println("enter your AccountId ex :[1234567-ASDF] ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {

								System.out.println("Enter withdraw Amount : ");
								amount = sc.nextInt();
								
								finalamount=transaction.withdrawAmount(AccountId, amount);
							
							System.out.println("updated balance"+finalamount);
								break;
							}
					 else {
							throw new AccountIDException();
					}

							
						}
						
					
				break;
			}
			case 4: {
				System.out.println("enter your AccountId ex :[1234567-ASDF] ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						transaction.showDetails(AccountId);
						break;
					} else
						throw new AccountIDException();
						
				}
				

				break;

			}
			case 5: {
				Loan loan=new Loan();
			
				System.out.println("enter loanId: ");
				loanId = sc.nextInt();
				loan.setLoanId(loanId);
				System.out.println("Enter LoanAmount : ");
				loanAmount = sc.nextDouble();
				loan.setLoanAmount(loanAmount);
				System.out.println("Enter Loan Type: 1.Home 2.Car 3.Education 4.Gold");
			
					loanType = sc.next();
					loan.setLoanType(loanType);
					System.out.println("Enter your accountID");
					LoanAccountId=sc.next();
			
							loan=transaction.getLoan(loan,LoanAccountId);
							
				break;
			}
			case 6: {
				System.out.println("enter loanId: ");
				loanId = sc.nextInt();
						System.out.println("enter the amount you want to pay");
						loanAmount=sc.nextDouble();
						System.out.println(transaction.payLoan(loanId,loanAmount));
				break;
			}
			
			case 7: {

				System.out.println("enter your Loanid ");
				loanId = sc.nextInt();
						System.out.println(transaction.showLoanDetails(loanId));

					
			break;
				
	}
			case 8: {
				System.out.println("Thank you visit again");
				break outerwhile;

			}
			default: {
				System.out.println("invalid choice");
				break;
			}
	}
	}
}
}
