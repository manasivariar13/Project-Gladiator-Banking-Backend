package com.lti.entity;

import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
<<<<<<< HEAD
=======
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_customer")

public class Customer {
	@Id
<<<<<<< HEAD
	@SequenceGenerator(name = "cust_seq", sequenceName = "CUSTOMER_SERVICE_REF_NO_SEQ",  allocationSize = 11)
	@GeneratedValue(generator = "cust_seq", strategy = GenerationType.SEQUENCE)
	@Column(name="service_ref_no")
	private int serviceRefNo;
	
	private String title;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="aadhaar_card_no")
	private String aadhaarNo;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="occupation_type")
	private String occupationType;
	
	@Column(name="source_of_income")
	private String sourceOfIncome;
	
	@Column(name="gross_annual_income")
	private float grossAnnualIncome;
	
	@Column(name="net_banking_requirement")
	private String netBankingRequirement;
	
	@Column(name="debit_card_requirement")
	private String debitCardRequirement;
	
	@Column(name="is_approved")
	private String isApproved;
	
	@Column(name="pan_card")
	private String panCard;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "res_address_id")
	private Address resAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "per_address_id")
	private Address perAddress;

	public int getServiceRefNo() {
		return serviceRefNo;
	}

	public void setServiceRefNo(int serviceRefNo) {
		this.serviceRefNo = serviceRefNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


=======
	@SequenceGenerator(name = "cust_seq", sequenceName = "CUSTOMER_SERVICE_REF_NO_SEQ", allocationSize = 11)
	@GeneratedValue(generator = "cust_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "customer_id")
	private int custId;

	private String customerPassword;

	Gender gender;

	@Column(name = "name")
	private String Name;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "aadhaar_card_no")
	private String aadhaarNo;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "pan_card_no")
	private String panCardNo;

	AccountStatus accountStatus;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Address Address;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> account;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Income income;

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

<<<<<<< HEAD
=======
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

<<<<<<< HEAD
	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public float getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(float grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getNetBankingRequirement() {
		return netBankingRequirement;
	}

	public void setNetBankingRequirement(String netBankingRequirement) {
		this.netBankingRequirement = netBankingRequirement;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

//	public Address getResAddress() {
//		return resAddress;
//	}
//
//	public void setResAddress(Address resAddress) {
//		this.resAddress = resAddress;
//	}
//
//	public Address getPerAddress() {
//		return perAddress;
//	}
//
//	public void setPerAddress(Address perAddress) {
//		this.perAddress = perAddress;
//	}

=======
	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}

>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
}
