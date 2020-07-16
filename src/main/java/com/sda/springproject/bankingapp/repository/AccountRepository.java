package com.sda.springproject.bankingapp.repository;

import com.sda.springproject.bankingapp.model.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {

	private String dbUserName = "root";
	private String dbPassword = "root";
	private String dbURL = "jdbc:mysql://localhost:3306/banking_app?serverTimezone=UTC";

	public Account getAccountById(int id) throws SQLException {
		Account account = null;

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM account WHERE id = ?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if(rs.next()) {
			account = new Account();
			account.setId(rs.getInt("id"));
			account.setAccountNo(rs.getString("accountNo"));
			account.setUserId(rs.getInt("userId"));
			account.setBalance(rs.getBigDecimal("balance"));
			account.setAccountType(rs.getString("accountType"));
			account.setCurrency(rs.getString("currency"));
		}

		return account;
	}


	public Account getAccountByAccountNumber(String accountNumber) throws SQLException {
		Account account = null;

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM account WHERE accountNo = ?");
		ps.setString(1, accountNumber);

		ResultSet rs = ps.executeQuery();

		if(rs.next()) {
			account = new Account();
			account.setId(rs.getInt("id"));
			account.setAccountNo(rs.getString("accountNo"));
			account.setUserId(rs.getInt("userId"));
			account.setBalance(rs.getBigDecimal("balance"));
			account.setAccountType(rs.getString("accountType"));
			account.setCurrency(rs.getString("currency"));
		}

		return account;
	}


	public Account getAccountByUserId(int userId) throws SQLException {
		Account account = null;

		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM account WHERE userId = ?");
		ps.setInt(1, userId);

		ResultSet rs = ps.executeQuery();

		if(rs.next()) {
			account = new Account();
			account.setId(rs.getInt("id"));
			account.setAccountNo(rs.getString("accountNo"));
			account.setUserId(rs.getInt("userId"));
			account.setBalance(rs.getBigDecimal("balance"));
			account.setAccountType(rs.getString("accountType"));
			account.setCurrency(rs.getString("currency"));
		}

		return account;
	}
}
