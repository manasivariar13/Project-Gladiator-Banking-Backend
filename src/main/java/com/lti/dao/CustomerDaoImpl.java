package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Account;
import com.lti.entity.Customer;
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
		transaction.setAccount(toAccount);
		transaction.setAmount(amount);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionType(TransactionType.NEFT);
		transaction.setMode("Credit");
		em.persist(transaction);

		Transaction transaction1 = new Transaction();
		transaction1.setAccount(fromAccount);
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
	public Transaction addOrUpdateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		Transaction tr = em.merge(transaction);
		return tr;

	}

	@Transactional
	public List<Transaction> findtoprec() {
		// TODO Auto-generated method stub
		String jpql = "select tx from Transaction tx WHERE rownum<=5 ORDER BY transactionId DESC";
		TypedQuery<Transaction> query = em.createQuery(jpql, Transaction.class);
		return query.getResultList();
	}
	
	@Transactional
	public boolean isUserExists(int custId) {
//		String jpql="select count(c.custId)>0 from Customer c where c.custId=:custId";
//		TypedQuery<Customer> query=em.createNamedQuery(jpql, Customer.class);
//		query.setParameter("custId",custId);
//		Customer cust=query.getSingleResult();
//		return cust!=null?true:false;
		return em.find(Customer.class, custId) != null;
	}
	
	@Transactional
	public Customer addOrUpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer c = em.merge(customer);
		return c;
	}

	public boolean login(int custId, String password) {
		String jpql = "select u from Customer c where c.userId=:cid and c.password=:pwd";

		TypedQuery<User> query = em.createQuery(jpql, Customer.class);
		query.setParameter("cid", custId);
		query.setParameter("pwd", password);

		Customer customer=null;
		try {
			customer = query.getSingleResult(); 
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
