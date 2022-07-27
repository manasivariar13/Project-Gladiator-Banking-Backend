package com.lti.service;

import java.util.List;

import com.lti.entity.Account;
import com.lti.entity.Beneficiary;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;

public interface CustomerService {

	String addBeneficiary(Beneficiary beneficiary);

	List<Beneficiary> viewAllBeneficiaries(int accNo);

	String deleteBeneficiary(int beneficiaryId);

	Beneficiary findBeneficiary(int beneficiaryId);

	List<Transaction> findTopFiveTransactions(int accNo);

	String signup(Customer customer);

	boolean login(int customerId, String password);

//	Account services 

	String openAccount(Account account);

	Account accountSummary(int accountNumber);

	List<Transaction> accountStatement(int accountNumber);

	String fundTransfer(Account fromAccount, Account toAccount, double amount);

}
