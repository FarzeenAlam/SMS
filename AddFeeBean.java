package com.tgi.sms.bean;

import java.sql.Timestamp;
import java.util.List;

import com.tgi.sms.model.Course;
import com.tgi.sms.model.Student;

public class AddFeeBean {

	private int FeeId;
	private Timestamp DateTime;
	private double Amount;
	private String TransactionType;
	private String InvoiceId;
	private int student;
	
	private List<Integer> coursesList;

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

	public void setInvoiceId(String invoiceId) {
		InvoiceId = invoiceId;
	}

	public int getStudent() {
		return student;
	}

	public void setStudent(int student) {
		this.student = student;
	}

	public List<Integer> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(List<Integer> coursesList) {
		this.coursesList = coursesList;
	}

	@Override
	public String toString() {
		return "AddFeeBean [FeeId=" + FeeId + ", DateTime=" + DateTime + ", Amount=" + Amount + ", TransactionType="
				+ TransactionType + ", InvoiceId=" + InvoiceId + ", student=" + student + ", coursesList=" + coursesList
				+ "]";
	}
	
	
	
	

}
