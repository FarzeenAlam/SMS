package com.tgi.sms.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fee_log")
public class FeeLog {

	@Id
	@GeneratedValue
	@Column(name="fee_id")
	private int FeeId;
	
	@Column(name="date_time")
	private Timestamp DateTime;
	
	@Column(name="amount")
	private double Amount;
	
	@Column(name="transaction_type")
	private String TransactionType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="stud_id")
	private Student student;
	
	@ManyToMany(mappedBy="feelog")
	private Set<Course> course;

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "FeeLog [FeeId=" + FeeId + ", DateTime=" + DateTime + ", Amount=" + Amount + ", TransactionType="
				+ TransactionType + ", student=" + student + ", course=" + course + "]";
	}
	
	
}