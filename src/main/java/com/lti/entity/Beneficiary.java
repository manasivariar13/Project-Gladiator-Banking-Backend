package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
<<<<<<< HEAD
import javax.persistence.OneToOne;
=======
import javax.persistence.ManyToOne;
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_beneficiary")
public class Beneficiary {
<<<<<<< HEAD
	
	@Id
	@SequenceGenerator(name = "ben_seq", sequenceName = "BEN_ID_SEQ", allocationSize = 2)
	@GeneratedValue(generator = "ben_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "beneficiary_id")
	private int beneficiaryId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="beneficiary_ac_no")
	private Account account;
	
	@Column(name = "beneficiary_name")
	private String beneficiaryName;
	
	@Column(name = "beneficiary_nick_name")
	private String beneficiaryNickName;
=======

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
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

<<<<<<< HEAD

=======
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
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

<<<<<<< HEAD
	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}

	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

=======
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
}
