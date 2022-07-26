package com.lti.entity;

<<<<<<< HEAD
import java.time.LocalDateTime;
=======
import java.time.LocalDate;
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560

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
@Table(name = "table_transaction")
public class Transaction {
	@Id
<<<<<<< HEAD
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
=======
	@SequenceGenerator(name = "trans_seq", sequenceName = "TRANSACTION_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "trans_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "transaction_Id")
	private int transactionId;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "account_number")
	private Account account;

	@Column(name = "tx_amount")
	private double amount;

	@Column(name = "transaction_mode")
	private String mode;

	@Column(name = "tx_type")
	TransactionType transactionType;

	@Column(name = "tx_date")
	private LocalDate transactionDate;
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

<<<<<<< HEAD
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
=======
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
	}

	public double getAmount() {
		return amount;
	}

<<<<<<< HEAD
=======
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

<<<<<<< HEAD
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
=======
>>>>>>> e6fd0925a29f411700679ef6f174ada672a53560
}
