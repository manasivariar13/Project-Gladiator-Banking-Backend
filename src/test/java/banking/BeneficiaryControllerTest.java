package banking;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.CustomerController;
import com.lti.entity.Beneficiary;


public class BeneficiaryControllerTest {

	CustomerController controller;
	@Before
	public void initializeDao(){
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		controller=context.getBean(CustomerController.class);
	}

	@Test
	public void addBeneficiaryTest() {
		/*
		 * String
		 * expectedMessage="Unexpected Error occured!!!Beneficiary addition failed!!";
		 * String actualMessage=controller.addBeneficiary(null);
		 * assertTrue(expectedMessage.equals(actualMessage));
		 */
		Beneficiary beneficiary=new Beneficiary();
		beneficiary.setBeneficiaryName("Micheal Shark");
		beneficiary.setBeneficiaryNickName("Mic");
		String actualMessage=controller.addBeneficiary(beneficiary);
		System.out.println(actualMessage);
	}
	
	@Test
	public void findBeneficiaryTest() {
		Beneficiary beneficiary =controller.findBeneficiaryById(8);
		assertNotNull(beneficiary);
		System.out.println(beneficiary.getBeneficiaryName());
	}
	@Test
	public void viewAllBeneficiariesTest() {
		List<Beneficiary> beneficiaries=controller.viewAllBeneficiaries();
		assertNotEquals(10, beneficiaries.size());
		for(Beneficiary b: beneficiaries) {
			System.out.println(b.getBeneficiaryId()+" "+b.getBeneficiaryName()+" "+b.getBeneficiaryNickName());
		}
	}
	@Test
	public void removeBenificiaryTest() {
		controller.deleteBeneficiary(8);
	}

}
