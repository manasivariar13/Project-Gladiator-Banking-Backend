package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_beneficiary")
public class Beneficiary {

	@Id
	@SequenceGenerator(name = "ben_seq", sequenceName = "BEN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ben_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "beneficiary_id")
	private int beneficiaryId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_number")
	private Account account;

	@Column(name = "beneficiary_name")
	private String beneficiaryName;

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

}
