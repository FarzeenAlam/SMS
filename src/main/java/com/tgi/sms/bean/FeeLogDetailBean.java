package com.tgi.sms.bean;

import java.sql.Timestamp;

public class FeeLogDetailBean {

	private int StudentId;
	private String CourseTitle;
	private double Amount;
	private Timestamp DateTime;

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int StudentId) {
		this.StudentId = StudentId;
	}

	public String getCourseTitle() {
		return CourseTitle;
	}

	public void setCourseTitle(String CourseTitle) {
		this.CourseTitle = CourseTitle;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double Amount) {
		this.Amount = Amount;
	}

	public Timestamp getDateTime() {
		return DateTime;
	}

	public void setDateTime(Timestamp DateTime) {
		this.DateTime = DateTime;
	}

	@Override
	public String toString() {
		return "FeeLogDetailBean [StudentId=" + StudentId + ", CourseTitle=" + CourseTitle + ", Amount=" + Amount
				+ ", DateTime=" + DateTime + "]";
	}


}
