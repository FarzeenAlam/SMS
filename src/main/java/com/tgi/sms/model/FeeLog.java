package com.tgi.sms.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="fee_log")
public class FeeLog {

	@Id
	@GeneratedValue
	@Column(name="fee_log_id")
	private int FeeId;
	
	@Column(name="date_time")
	private Timestamp DateTime;
	
	@Column(name="amount")
	private double Amount;
	
	@Column(name="transaction_type")
	private String TransactionType;
	

	@Column(name="invoice_id")
	private String InvoiceId;
	
	@OneToOne
	@JoinColumn(name="stud_id", referencedColumnName = "stud_id")
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public FeeLog() {
		super();
	}

	public int getFeeId() {
		return FeeId;
	}

	public void setFeeId(int feeId) {
		FeeId = feeId;
	}

	public Timestamp getDateTime() {
		return DateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		DateTime = dateTime;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public String getInvoiceId() {
		return InvoiceId;
	}

	@Override
	public String toString() {
		return "FeeLog [FeeId=" + FeeId + ", DateTime=" + DateTime + ", Amount=" + Amount + ", TransactionType="
				+ TransactionType + ", InvoiceId=" + InvoiceId + ", student=" + student + "]";
	}

	public void setInvoiceId(String invoiceId) {
		InvoiceId = invoiceId;
	}
	
}