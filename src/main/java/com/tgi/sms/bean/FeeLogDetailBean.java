package com.tgi.sms.bean;

import java.sql.Timestamp;

public class FeeLogDetailBean {

	private int studentId;
	private String courseTitle;
	private double amount;
	private Timestamp dateTime;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "FeeLogDetailBean [studentId=" + studentId + ", courseTitle=" + courseTitle + ", amount=" + amount
				+ ", dateTime=" + dateTime + "]";
	}

}
