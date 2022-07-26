package banking;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.entity.Beneficiary;


public class BenificiaryTest {
	CustomerDao dao;
	
	@Before
	public void initializeDao(){
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		dao=context.getBean(CustomerDao.class);
	}

	@Test 
	public void addben() {
		Beneficiary beneficiary=new Beneficiary();
		beneficiary.setBeneficiaryName("Jatli Kate");
		beneficiary.setBeneficiaryNickName("Jat");
		Beneficiary savedBen=dao.addBeneficiary(beneficiary);
		assertNotNull(savedBen);
	}
	
	@Test
	public void findTest() {
		Beneficiary beneficiary=dao.findBeneficiaryById(10);
		assertNotNull(beneficiary);
		System.out.println(beneficiary.getBeneficiaryId()+" "+beneficiary.getBeneficiaryName()+" "+beneficiary.getBeneficiaryNickName());
	}
	
	@Test
	public void viewTest() {
		List<Beneficiary> beneficiaries=dao.viewAllBeneficiaries();
		assertNotEquals(10, beneficiaries.size());
		for(Beneficiary b: beneficiaries) {
			System.out.println(b.getBeneficiaryId()+" "+b.getBeneficiaryName()+" "+b.getBeneficiaryNickName());
		}
	}
	@Test
	public void removeBen() {
		dao.deleteBeneficiary(10);
	}
	
	@Test
	public void findName() {
		Beneficiary beneficiary=dao.findBeneficiaryByName("Joseph Meclin");
		assertNotNull(beneficiary);
		System.out.println(beneficiary.getBeneficiaryId()+" "+beneficiary.getBeneficiaryName()+" "+beneficiary.getBeneficiaryNickName());

	}

	
}
