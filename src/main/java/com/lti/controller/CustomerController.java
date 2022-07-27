package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.Account;
import com.lti.entity.Beneficiary;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;
import com.lti.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	public String addBeneficiary(Beneficiary beneficiary) {
		String message = customerService.addBeneficiary(beneficiary);
		return message;
	}

	public Beneficiary findBeneficiaryById(int beneficiaryId) {
		return customerService.findBeneficiary(beneficiaryId);
	}

	public List<Beneficiary> viewAllBeneficiaries(int accNo) {
		return customerService.viewAllBeneficiaries(accNo);
	}

	public String deleteBeneficiary(int beneficiaryId) {
		String message = customerService.deleteBeneficiary(beneficiaryId);
		return message;
	}

	public String openAccount(Account account) {
		return customerService.openAccount(account);
	}

	public Account accountSummary(int accountNumber) {
		return customerService.accountSummary(accountNumber);
	}

	public List<Transaction> findTopFiveTransactions(int accountNumber) {
		return customerService.findTopFiveTransactions(accountNumber);
	}

	public List<Transaction> accountStatement(int accountNumber) {
		return customerService.accountStatement(accountNumber);
	}

	public String fundTransfer(Account fromAccount, Account toAccount, double amount) {
		return customerService.fundTransfer(fromAccount, toAccount, amount);
	}

	public String signup(Customer customer) {
		return customerService.signup(customer);
	}

	public boolean login(int customerId, String password) {
		return customerService.login(customerId, password);
	}

}
