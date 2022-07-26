package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Account;
import com.lti.entity.Beneficiary;
import com.lti.entity.Transaction;
import com.lti.entity.TransactionType;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Account openAccount(Account account) {
		em.persist(account);
		return account;
	}

	@Transactional
	public Account accountSummary(int accountNumber) {
		return em.find(Account.class, accountNumber);
	}

	@Transactional
	public List<Transaction> accountStatement() {
		String jpql = "select t from Transaction t";
		TypedQuery<Transaction> query = em.createQuery(jpql, Transaction.class);
		return query.getResultList();
	}

	@Transactional
	public Transaction fundTransfer(Account fromAccount, Account toAccount, double amount) {
		Transaction transaction = new Transaction();
		transaction.setToAccount(toAccount);
		transaction.setAmount(amount);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionType(TransactionType.NEFT);
		transaction.setMode("Credit");
		em.persist(transaction);

		Transaction transaction1 = new Transaction();
		transaction1.setToAccount(fromAccount);
		transaction1.setAmount(amount);
		transaction1.setTransactionDate(LocalDate.now());
		transaction1.setTransactionType(TransactionType.NEFT);
		transaction1.setMode("Debit");
		em.persist(transaction1);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		em.merge(fromAccount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		em.merge(toAccount);
		return transaction;
	}
	@Transactional
	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		Beneficiary beneficiaryPersisted=em.merge(beneficiary);
		return beneficiaryPersisted;
	}

	public List<Beneficiary> viewAllBeneficiaries() {
		String jpql="select b from Beneficiary b";
		TypedQuery<Beneficiary> query=em.createQuery(jpql,Beneficiary.class);
		return query.getResultList();
	}

	@Transactional
	public void deleteBeneficiary(int beneficiaryId) {
		Beneficiary beneficiary=findBeneficiaryById(beneficiaryId);
		em.remove(beneficiary);
		System.err.println("Beneficiary Removed ");
		
	}

	public Beneficiary findBeneficiaryById(int beneficiaryId) {
		return em.find(Beneficiary.class, beneficiaryId);
	}

}
