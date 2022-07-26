package com.lti.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_transaction")
public class Transaction {
	@Id
	@SequenceGenerator(name = "trans_seq", sequenceName = "TRANSACTION_ID_SEQ",  allocationSize = 1)
	@GeneratedValue(generator = "trans_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "transaction_Id")
	private int transactionId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="from_account")
	private Account fromAccount; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="to_account")
	private Account toAccount; 
	
	@Column(name = "tx_amount")
	private double amount;
	
	@Column(name = "tx_type")
	private TransactionType transactionType;
	
	private String remarks;
	private String mode;
	
	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public Account getFromAccount() {
		return fromAccount;
	}


	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}


	public Account getToAccount() {
		return toAccount;
	}


	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}


	public LocalDate getTransactionDate() {
		return transactionDateTime;
	}


	public void setTransactionDate(LocalDate localDate) {
		this.transactionDateTime = localDate;
	}

	@Column(name = "tx_date_time")
	private LocalDate transactionDateTime;


	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	}
	
