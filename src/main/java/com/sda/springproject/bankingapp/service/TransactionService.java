package com.sda.springproject.bankingapp.service;

import com.sda.springproject.bankingapp.model.Transaction;

public class TransactionService {

	public void sendMoney(Transaction transaction) {

		if(!validateSenderBalance(transaction)) {
			return;
		}

		if(!validateReceiverAccountNumber(transaction)) {
			return;
		}

		if(!validateCurrency(transaction)) {
			return;
		}

		//Send money
	}

	private boolean validateSenderBalance(Transaction transaction) {
		return true;
	}

	private boolean validateReceiverAccountNumber(Transaction transaction) {
		return true;
	}

	private boolean validateCurrency(Transaction transaction) {
		return true;
	}
}
