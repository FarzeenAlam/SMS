package com.tgi.sms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="stud_id")
	public int StudentId;
	
	public FeeLog getFeelog() {
		return feelog;
	}

	public void setFeelog(FeeLog feelog) {
		this.feelog = feelog;
	}

	@Column(name="stud_name")
	public String StudentName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id")
	public Department department;
	
	@OneToOne(mappedBy = "student")
	private FeeLog feelog;
	
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", department=" + department
				+ ", feelog=" + feelog + ", instructor=" + instructor + ", course=" + course + "]";
	}

	@OneToMany(mappedBy = "student")
	private List<Instructor> instructor;

	@OneToMany(mappedBy = "student")
	private List<Course> course;
	
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

	public List<Instructor> getInstructor() {
		return instructor;
	}

	public void setInstructor(List<Instructor> instructor) {
		this.instructor = instructor;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
