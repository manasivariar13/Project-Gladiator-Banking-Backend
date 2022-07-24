package banking;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.dao.CustomerDaoImpl;
import com.lti.entity.Account;
import com.lti.entity.AccountType;
import com.lti.entity.Customer;
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
	public void fundTransferTest() {
		Account a1 = dao.accountSummary(1000005);
		Account a2 = dao.accountSummary(1000006);
		assertNotNull(dao.fundTransfer(a1, a2, 500));
	}

}
