package com.tgi.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "stud_id")
	public int StudentId;

	@Column(name = "stud_name")
	public String StudentName;

	@Column(name = "status")
	public boolean StudentStatus;

	public boolean isStudentStatus() {
		return StudentStatus;
	}

	public void setStudentStatus(boolean studentStatus) {
		StudentStatus = studentStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	public Department department;

	@OneToOne(mappedBy = "student")
	private FeeLog feelog;

	public Student() {
		super();
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StudentStatus=" + StudentStatus
				+ ", department=" + department + "]";
	}

}
