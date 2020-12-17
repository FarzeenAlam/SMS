package com.tgi.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_fee_log")
public class StudentFeeLog {

	@Id
	@GeneratedValue
	@Column(name="student_fee_log_id")
	private int StudentFeeLogId;
	
	public StudentFeeLog(String invoiceId, Course course) {
		
		InvoiceId = invoiceId;
		this.course = course;
	}

	@Column(name="invoice_id")
	private String InvoiceId;

	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	@Override
	public String toString() {
		return "StudentFeeLog [StudentFeeLogId=" + StudentFeeLogId + ", InvoiceId=" + InvoiceId + "]";
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getStudentFeeLogId() {
		return StudentFeeLogId;
	}

	public void setStudentFeeLogId(int studentFeeLogId) {
		StudentFeeLogId = studentFeeLogId;
	}

	public String getInvoiceId() {
		return InvoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		InvoiceId = invoiceId;
	}
	
}
