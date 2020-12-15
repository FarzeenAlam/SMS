package com.tgi.sms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="stud_id")
	public int StudentId;
	
	@Column(name="stud_name")
	public String StudentName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id")
	public Department department;
	
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", department=" + department
				+ ", feelog=" + feelog + ", instructor=" + instructor + ", course=" + course + "]";
	}

	@OneToMany(mappedBy="student")
	public Set<FeeLog> feelog;
	
	@ManyToMany(mappedBy="student")
	private Set<Instructor> instructor = new HashSet<Instructor>();
	
	@ManyToMany(mappedBy="student")
	private Set<Course> course = new HashSet<Course>();

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

	public Set<Instructor> getInstructor() {
		return instructor;
	}

	public void setInstructor(Set<Instructor> instructor) {
		this.instructor = instructor;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	
}
