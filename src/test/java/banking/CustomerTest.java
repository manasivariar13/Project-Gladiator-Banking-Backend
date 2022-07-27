package banking;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.dao.CustomerDaoImpl;
import com.lti.entity.Account;
import com.lti.entity.AccountStatus;
import com.lti.entity.AccountType;
import com.lti.entity.Beneficiary;
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
		acc.setBalance(20000);
		acc.setTransactionPassword("test123");
//		System.out.println(AccountType.valueOf("Current"));
		acc.setType(AccountType.Current);
//		acc.setCustomer(customer);

		Account newAccount = dao.openAccount(acc);

		assertNotNull(newAccount);

	}

	@Test
	public void accountSummaryTest() {
		Account a = dao.accountSummary(100001);
		assertNotNull(a);
		System.out.println(a.getAccountNumber() + " " + a.getBalance());
	}

	@Test
	public void accountStatementTest() {
		List<Transaction> transactions = dao.accountStatement(100001);
		assertFalse(transactions.isEmpty());
		for (Transaction t : transactions) {
			System.out.println(t.getTransactionId() + " " + t.getAmount() + " " + t.getTransactionDate() + " "
					+ t.getTransactionType() + " " + t.getAccount().getAccountNumber() + " " + t.getMode());
		}
	}

	@Test
	public void fundTransferTest() {
		Account a1 = dao.accountSummary(100001);
		Account a2 = dao.accountSummary(100003);
		assertNotNull(dao.fundTransfer(a1, a2, 1000));
	}

	@Test
	public void isCustomerExistTest() {
		boolean isCustomerExist = dao.isCustomerExists(100003);
		assertEquals(true, isCustomerExist);
	}

//	@Test
//	public void addOrUpdateTransactionTest() {
//		Transaction transaction=new Transaction();
//		Account account=new Account();
//		account.setAccountNumber(87879809);
//		transaction.setAmount(400000);
//		transaction.setTransactionType(TransactionType.IMPS);
//		transaction.setTransactionDate(LocalDate.of(2022, 12, 7));
//		
//		dao.addOrUpdateTransaction(transaction);
//		
//		
//	}

	@Test
	public void findtoprec() {
		List<Transaction> transactions = dao.findtoprec(100001);
		for (Transaction tx : transactions) {
			System.out.println(tx.getTransactionId() + " " + tx.getAmount() + " " + tx.getTransactionDate());
		}
	}

	@Test
	public void addOrUpdateCustomerTest() {
		Customer customer = new Customer();
		customer.setName("John");
		customer.setAadhaarNo("123443211234");
		customer.setAccountStatus(AccountStatus.Pending);
		customer.setCustomerPassword("john@123");
		customer.setDateOfBirth(LocalDate.of(2000, 10, 15));
		customer.setEmailId("john@gmail.com");
		customer.setGender(Gender.Male);
		customer.setMobileNo("9876567890");
		customer.setPanCardNo("AJQOEP213J");

		dao.addOrUpdateCustomer(customer);
	}

	@Test
	public void addben() {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setBeneficiaryName("Jatli Kate");
//		beneficiary.setBeneficiaryAccount(dao.accountSummary(accountNumber));
		Beneficiary savedBen = dao.addBeneficiary(beneficiary);
		assertNotNull(savedBen);
	}

	@Test
	public void findTest() {
		Beneficiary beneficiary = dao.findBeneficiaryById(10);
		assertNotNull(beneficiary);
		System.out.println(beneficiary.getBeneficiaryId() + " " + beneficiary.getBeneficiaryName());
	}

	@Test
	public void viewTest() {
		List<Beneficiary> beneficiaries = dao.viewAllBeneficiaries(100001);
		assertNotEquals(10, beneficiaries.size());
		for (Beneficiary b : beneficiaries) {
			System.out.println(b.getBeneficiaryId() + " " + b.getBeneficiaryName());
		}
	}

	@Test
	public void removeBen() {
		dao.deleteBeneficiary(10);
	}

//	@Test
//	public void findName() {
//		Beneficiary beneficiary=dao.findBeneficiaryByName("Joseph Meclin");
//		assertNotNull(beneficiary);
//		System.out.println(beneficiary.getBeneficiaryId()+" "+beneficiary.getBeneficiaryName());
//
//	}

}