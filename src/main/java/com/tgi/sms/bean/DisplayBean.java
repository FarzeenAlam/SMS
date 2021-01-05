package com.tgi.sms.bean;

import java.sql.Timestamp;

public class DisplayBean {
	private int studentId;
	private Timestamp lastFee;
	private Timestamp expiry;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Timestamp getLastFee() {
		return lastFee;
	}

	public void setLastFee(Timestamp lastFee) {
		this.lastFee = lastFee;
	}

	public Timestamp getExpiry() {
		return expiry;
	}

	public void setExpiry(Timestamp expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "DisplayBean [studentId=" + studentId + ", lastFee=" + lastFee + ", expiry=" + expiry + "]";
	}

}
