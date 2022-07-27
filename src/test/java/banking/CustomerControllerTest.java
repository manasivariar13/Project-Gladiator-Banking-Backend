package banking;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.CustomerController;
import com.lti.entity.Account;
import com.lti.entity.AccountStatus;
import com.lti.entity.AccountType;
import com.lti.entity.Beneficiary;
import com.lti.entity.Customer;
import com.lti.entity.Gender;
import com.lti.entity.Transaction;

public class CustomerControllerTest {

	CustomerController controller;

	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		controller = context.getBean(CustomerController.class);
	}

	@Test
	public void addBeneficiaryTest() {
		/*
		 * String
		 * expectedMessage="Unexpected Error occured!!!Beneficiary addition failed!!";
		 * String actualMessage=controller.addBeneficiary(null);
		 * assertTrue(expectedMessage.equals(actualMessage));
		 */
		Beneficiary beneficiary = new Beneficiary();
		Account acc = new Account();
		acc.setAccountNumber(100005);
		beneficiary.setBeneficiaryName("Manasi Variar");
		beneficiary.setCustomerAccountNumber(100002);
		beneficiary.setBeneficiaryAccount(acc);
		String actualMessage = controller.addBeneficiary(beneficiary);
		System.out.println(actualMessage);
	}

//	@Test
//	public void findBeneficiaryTest() {
//		Beneficiary beneficiary = controller.findBeneficiaryById(8);
//		assertNotNull(beneficiary);
//		System.out.println(beneficiary.getBeneficiaryName());
//	}

	@Test
	public void findBeneficiaryTest() {
		Beneficiary beneficiary = controller.findBeneficiaryById(307);
		System.out.println(beneficiary.getBeneficiaryName());
	}

	@Test
	public void viewAllBeneficiariesTest() {
		List<Beneficiary> beneficiaries = controller.viewAllBeneficiaries(100001);
		assertNotEquals(10, beneficiaries.size());
		for (Beneficiary b : beneficiaries) {
			System.out.println(b.getBeneficiaryId() + " " + b.getBeneficiaryName());
		}
	}

	@Test
	public void removeBeneficiaryTest() {
		controller.deleteBeneficiary(306);
	}

	@Test
	public void openAccountTest() {
		Account acc = new Account();
		acc.setBalance(8000);
		acc.setTransactionPassword("test123");
		acc.setType(AccountType.Savings);
//		acc.setCustomer(customer);

		System.out.println(controller.openAccount(acc));
	}

	@Test
	public void topFiveTransactionsTest() {
		List<Transaction> transactions = controller.findTopFiveTransactions(100001);
		for (Transaction t : transactions) {
			System.out.println(t.getTransactionId() + " " + t.getAmount() + " " + t.getTransactionDate() + " "
					+ t.getTransactionType() + " " + t.getAccount().getAccountNumber() + " " + t.getMode());
		}
	}

	@Test
	public void accountSummaryTest() {
		Account a = controller.accountSummary(100001);
		System.out.println(a.getAccountNumber() + " " + a.getBalance());
	}

	@Test
	public void accountStatementTest() {
		List<Transaction> transactions = controller.accountStatement(100003);
//		assertFalse(transactions.isEmpty());
		for (Transaction t : transactions) {
			System.out.println(t.getTransactionId() + " " + t.getAmount() + " " + t.getTransactionDate() + " "
					+ t.getTransactionType() + " " + t.getAccount().getAccountNumber() + " " + t.getMode());
		}
	}

	@Test
	public void fundTransferTest() {
		Account a1 = controller.accountSummary(100003);
		Account a2 = controller.accountSummary(100005);
		System.out.println(controller.fundTransfer(a1, a2, 50000));
//		assertNotNull(controller.fundTransfer(a1, a2, 1000));S
	}

	@Test
	public void signupTest() {
		Customer customer = new Customer();
		customer.setName("Manasi");
		customer.setAadhaarNo("123443211234");
		customer.setAccountStatus(AccountStatus.Pending);
		customer.setCustomerPassword("manasi@123");
		customer.setDateOfBirth(LocalDate.of(1999, 12, 13));
		customer.setEmailId("manasi@gmail.com");
		customer.setGender(Gender.Female);
		customer.setMobileNo("9876567890");
		customer.setPanCardNo("AJQOEP213J");

		System.out.println(controller.signup(customer));
	}

	@Test
	public void loginTest() {
		boolean user = controller.login(404, "manasi@123");
		System.out.println(user);
	}

}
