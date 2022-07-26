package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.entity.Beneficiary;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao dao;
	
	public String addBeneficiary(Beneficiary beneficiary) {
		try {
			Beneficiary beneficiary2=dao.addBeneficiary(beneficiary);
			return "Beneficiary added successfully!! Beneficiary ID : "+beneficiary2.getBeneficiaryId();
		} catch (Exception e) {
			return "Unexpected Error occured!!!Beneficiary addition failed!!";
		}
	}

	public List<Beneficiary> viewAllBeneficiaries() {
		return dao.viewAllBeneficiaries();
	}

	public String deleteBeneficiary(int beneficiaryId) {
		try {
			dao.deleteBeneficiary(beneficiaryId);
			return "Beneficiary deleted successfully!! ";
		} catch (Exception e) {
			return "Unexpected Error occured!!!Beneficiary was not deleted!";
		}

	}

	public Beneficiary findBeneficiaryById(int beneficiaryId) {
		// TODO Auto-generated method stub
		return dao.findBeneficiaryById(beneficiaryId);
	}

}
