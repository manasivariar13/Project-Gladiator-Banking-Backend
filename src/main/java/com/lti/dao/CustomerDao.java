package com.lti.dao;

import java.util.List;

import com.lti.entity.Account;
import com.lti.entity.Transaction;

public interface CustomerDao {

	Account openAccount(Account account);

	Account accountSummary(int accountNumber);

	List<Transaction> accountStatement();

	Transaction fundTransfer(Account fromAccount, Account toAccount, double amount);

	
	Beneficiary addBeneficiary(Beneficiary beneficiary) ;
	List<Beneficiary> viewAllBeneficiaries();
	Beneficiary findBeneficiaryById(int beneficiaryId);
	void deleteBeneficiary(int beneficiaryId);


}
