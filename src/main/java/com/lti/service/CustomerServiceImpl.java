package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.entity.Account;
import com.lti.entity.Beneficiary;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;
import com.lti.exception.InsufficientFundsException;
import com.lti.exception.MinimumAmountException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;

	public String addBeneficiary(Beneficiary beneficiary) {
		try {
			if (dao.isCustomerExists(beneficiary.getBeneficiaryAccount().getAccountNumber())) {
				Beneficiary beneficiary2 = dao.addBeneficiary(beneficiary);
				return "Beneficiary added successfully. Beneficiary ID : " + beneficiary2.getBeneficiaryId();
			} else {
				return "Beneficiary doesn't exists. Please add correct account number.";
			}
		} catch (Exception e) {
			return "Unexpected Error occured. Beneficiary addition failed.";
		}
	}

	public List<Beneficiary> viewAllBeneficiaries(int accNo) {
		return dao.viewAllBeneficiaries(accNo);
	}

	public String deleteBeneficiary(int beneficiaryId) {
		try {
			dao.deleteBeneficiary(beneficiaryId);
			return "Beneficiary deleted successfully.";
		} catch (Exception e) {
			return "Unexpected Error occured. Beneficiary was not deleted.";
		}

	}

	public Beneficiary findBeneficiary(int beneficiaryId) {
		return dao.findBeneficiaryById(beneficiaryId);
	}

//	Account service implementations

	public String openAccount(Account account) {
		try {
			Account acc = dao.openAccount(account);
			return "Registration has been initiated. We'll let you know the Account status soon. Your customer ID: "
					+ account.getCustomer().getCustId();
		} catch (Exception e) {
//			return e.getMessage();
			return "Unexpected error occured. Account Registration failed.";
		}
	}

	public List<Transaction> findTopFiveTransactions(int accountNumber) {
		return dao.findtoprec(accountNumber);
	}

	public Account accountSummary(int accountNumber) {
		return dao.accountSummary(accountNumber);
	}

	public List<Transaction> accountStatement(int accountNumber) {
		return dao.accountStatement(accountNumber);
	}

	public String fundTransfer(Account fromAccount, Account toAccount, double amount) {
		try {
			if (amount < 100) {
				throw new MinimumAmountException("Amount must be greater than 100");
//				return "Amount must be minimum 100";
			} else if (amount > fromAccount.getBalance()) {
				throw new InsufficientFundsException("Insufficent balance");
//				return "Insufficent balance";
			} else {
				Transaction transaction = dao.fundTransfer(fromAccount, toAccount, amount);
				return "Fund transfer successful. Transaction ID: " + transaction.getTransactionId();
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String signup(Customer customer) {
		try {
			Customer customer2 = dao.addOrUpdateCustomer(customer);
			return "Sign up successful. Your userId is: " + customer2.getCustId();
		} catch (Exception e) {
			return "Unexpected error occured. Sign up failed.";
		}
	}

	public boolean login(int customerId, String password) {
		return dao.login(customerId, password);
	}

}
