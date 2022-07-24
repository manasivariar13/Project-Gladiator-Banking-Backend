package com.lti.dao;

import com.lti.entity.Account;
import com.lti.entity.Transaction;

public interface CustomerDao {

	Account openAccount(Account account);

	Account accountSummary(int accountNumber);

	Transaction fundTransfer(Account fromAccount, Account toAccount, double amount);

}
