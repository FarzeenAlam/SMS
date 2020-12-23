package com.tgi.sms.bean;

import java.sql.Timestamp;

public class FeeLogDetailBean {

	public int StudentId;
	private String CourseTitle;
	private double Amount;
	private Timestamp DateTime;

	public FeeLogDetailBean() {
		super();
	}

	public FeeLogDetailBean(int studentId, String courseTitle, double amount, Timestamp dateTime) {
		StudentId = studentId;
		CourseTitle = courseTitle;
		Amount = amount;
		DateTime = dateTime;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getCourseTitle() {
		return CourseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		CourseTitle = courseTitle;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public Timestamp getDateTime() {
		return DateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		DateTime = dateTime;
	}

	@Override
	public String toString() {
		return "FeeLogDetailBean [StudentId=" + StudentId + ", CourseTitle=" + CourseTitle + ", Amount=" + Amount
				+ ", DateTime=" + DateTime + "]";
	}

}
