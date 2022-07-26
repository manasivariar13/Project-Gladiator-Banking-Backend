package com.lti.service;

import java.util.List;

import com.lti.entity.Beneficiary;

public interface CustomerService {
	
	String addBeneficiary(Beneficiary beneficiary) ;
	List<Beneficiary> viewAllBeneficiaries();
	String deleteBeneficiary(int beneficiaryId);
	Beneficiary findBeneficiaryById(int beneficiaryId);

}
