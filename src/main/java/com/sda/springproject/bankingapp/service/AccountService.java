package com.sda.springproject.bankingapp.service;

import com.sda.springproject.bankingapp.model.Account;
import com.sda.springproject.bankingapp.repository.AccountRepository;

import java.sql.SQLException;

public class AccountService {

	private AccountRepository accountRepository = new AccountRepository();

	public Account getAccountById(int id) throws SQLException {
		return accountRepository.getAccountById(id);
	}

	public Account getAccountByAccountNumber(String accountNum) throws SQLException {
		return accountRepository.getAccountByAccountNumber(accountNum);
	}

	public Account getAccountByUserId(int userId) throws SQLException {
		return accountRepository.getAccountByUserId(userId);
	}
}
