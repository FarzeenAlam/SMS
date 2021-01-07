package com.tgi.sms.bean;

import java.util.Date;

public class DisplayBean {
	private int studentId;
	private Date lastFee;
	private Date expiry;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getLastFee() {
		return lastFee;
	}

	public void setLastFee(Date lastFee) {
		this.lastFee = lastFee;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "DisplayBean [studentId=" + studentId + ", lastFee=" + lastFee + ", expiry=" + expiry + "]";
	}

}
