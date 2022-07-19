package com.lti.entity;

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
	
	@Column(name = "tx_date_time")
	private LocalDateTime transactionDateTime;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Account getDebitAccount() {
		return fromAccount;
	}

	public void setDebitAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getCreditAccount() {
		return toAccount;
	}

	public void setCreditAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

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

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
}
