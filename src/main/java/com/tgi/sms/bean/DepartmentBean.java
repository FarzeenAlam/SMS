package com.tgi.sms.bean;

public class DepartmentBean {

	private int departmentId;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "DepartmentBean [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

}
