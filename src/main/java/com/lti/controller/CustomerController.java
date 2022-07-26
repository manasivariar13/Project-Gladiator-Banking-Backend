package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.entity.Beneficiary;
import com.lti.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService service;

	public String addBeneficiary(Beneficiary beneficiary) {
		String message = service.addBeneficiary(beneficiary);
		return message;
	}
	public Beneficiary findBeneficiaryById(int beneficiaryId) {
		return service.findBeneficiaryById(beneficiaryId);
	}
	public List<Beneficiary> viewAllBeneficiaries() {
		return service.viewAllBeneficiaries();
	}
	public String deleteBeneficiary(int beneficiaryId) {
		String message = service.deleteBeneficiary(beneficiaryId);
		return message;
	}

	

}
