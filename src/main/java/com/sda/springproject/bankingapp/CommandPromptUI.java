package com.sda.springproject.bankingapp;

import com.sda.springproject.bankingapp.config.AppConfig;
import com.sda.springproject.bankingapp.model.Account;
import com.sda.springproject.bankingapp.model.Transaction;
import com.sda.springproject.bankingapp.model.User;
import com.sda.springproject.bankingapp.service.AccountService;
import com.sda.springproject.bankingapp.service.LoginService;
import com.sda.springproject.bankingapp.service.TransactionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class CommandPromptUI {

	private ApplicationContext applicationContext;
	private LoginService loginService;
	private AccountService accountService;
	private TransactionService transactionService;

	public CommandPromptUI(){
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		loginService = applicationContext.getBean(LoginService.class);
		transactionService = new TransactionService();
		accountService = new AccountService();
	}

	public void initiateSystem() throws SQLException{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter User Id: ");
		int userId = sc.nextInt();

		sc.nextLine();
		System.out.println("Enter Password: ");
		String password = sc.nextLine();

		User user = new User(userId, password);

		boolean isUserValid = loginService.authenticateUser(user);

		if(!isUserValid) {
			System.out.println("Invalid User details... Good bye! ");
			return;
		}

		System.out.println("Select one of the following options:");

		System.out.println("1. Send Money");
		System.out.println("2. Check Balance");
		System.out.println("3. View Transaction History");

		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 1:
				System.out.println("Enter recipient account Number:");
				String recAcctNo = sc.nextLine();
				System.out.println("Enter amount:");
				BigDecimal amount = sc.nextBigDecimal();

				Account senderAcct = accountService.getAccountByUserId(userId);
				Account recvAcct = accountService.getAccountByAccountNumber(recAcctNo);

				Transaction transaction = new Transaction();
				//Populate object
				transactionService.sendMoney(transaction);


				break;
			case 2:
				System.out.println("Not yet implemented");
				break;
			case 3:
				System.out.println("Not yet implemented");
				break;
			default:
				System.out.println("Invalid option. Good Bye!");
		}
	}

	public static void main(String[] args) throws SQLException {
		CommandPromptUI ui = new CommandPromptUI();
		ui.initiateSystem();
	}
}
