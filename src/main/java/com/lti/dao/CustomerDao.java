package com.lti.dao;

import java.util.List;

import com.lti.entity.Account;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;

public interface CustomerDao {

	Account openAccount(Account account);

	Account accountSummary(int accountNumber);

	Transaction fundTransfer(Account fromAccount, Account toAccount, double amount);
	
	Transaction addOrUpdateTransaction(Transaction transaction);
	
	List<Transaction> findtoprec();
	
	boolean isUserExists(int custId);
	
	Customer addOrUpdateCustomer(Customer customer);

}
