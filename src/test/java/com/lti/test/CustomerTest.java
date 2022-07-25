package com.lti.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.entity.Account;
import com.lti.entity.AccountStatus;
import com.lti.entity.AccountType;
import com.lti.entity.Customer;
import com.lti.entity.Gender;
import com.lti.entity.Transaction;
import com.lti.entity.TransactionType;


public class CustomerTest {
	CustomerDao dao;

	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(CustomerDao.class);
	}

	@Test
	public void openAccountTest() {
		Account acc = new Account();
		acc.setBalance(12000);
		acc.setTransactionPassword("test123");
//		System.out.println(AccountType.valueOf("Current"));
		acc.setType(AccountType.SAVINGS);
//		acc.setCustomer(customer);

		Account newAccount = dao.openAccount(acc);

		assertNotNull(newAccount);

	}

	@Test
	public void accountSummaryTest() {
		Account a = dao.accountSummary(1000003);
		assertNotNull(a);
		System.out.println(a.getAccountNumber() + " " + a.getBalance());
	}

	@Test
	public void isUserExistTest() {
		boolean isUserExist=dao.isUserExists(35);
		assertEquals(true,isUserExist);
	}
	
	
	@Test
	public void fundTransferTest() {
		Account a1 = dao.accountSummary(1000005);
		Account a2 = dao.accountSummary(1000006);
		assertNotNull(dao.fundTransfer(a1, a2, 500));
	}
	
	@Test
	public void addOrUpdateTransactionTest() {
		Transaction transaction=new Transaction();
		Account account=new Account();
		account.setAccountNumber(87879809);
		transaction.setAmount(400000);
		transaction.setTransactionType(TransactionType.IMPS);
		transaction.setTransactionDate(LocalDate.of(2022, 12, 7));
		
		dao.addOrUpdateTransaction(transaction);
		
		
	}
	
	@Test
	public void findtoprec() {
		List<Transaction> transactions=dao.findtoprec();
		for (Transaction tx:transactions) {
			System.out.println(tx.getTransactionId()+" "+tx.getAmount()+" "+tx.getTransactionDate());
		}
		
	}
	
	@Test
	public void addOrUpdateCustomerTest() {
		Customer customer=new Customer();
		customer.setCustomerPassword("Loki@123");
		customer.setName("piki");
		customer.setAadhaarNo("123443211234");
		customer.setDateOfBirth(LocalDate.of(2000, 10, 15));
		customer.setPanCardNo("AJQOEP213J");
		customer.setAccountStatus(AccountStatus.Pending);
		customer.setEmailId("loki@gmail.com");
		customer.setGender(Gender.Male);
		customer.setMobileNo("9876567890");
		
		dao.addOrUpdateCustomer(customer);
	}
	
	
	
	

}
