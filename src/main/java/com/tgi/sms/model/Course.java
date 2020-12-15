package com.tgi.sms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue
	@Column(name="course_id")
	private int CourseId;
	
	@Column(name="course_title")
	private String CourseTitle;
	
	@Column(name="credit_hours")
	private int CreditHours;
	
//	@OneToMany
//	@JoinColumn(name="dept_id", referencedColumnName = "dept_id")
//	private Department department;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	
	@ManyToMany(mappedBy="course")
	private Set<Instructor> instructor = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name="course_student",
			joinColumns = {@JoinColumn(name="course_id")},
			inverseJoinColumns = {@JoinColumn(name="stud_id")}
			)
	private Set<Student> student = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name="course_feelog",
			joinColumns = {@JoinColumn(name="course_id")},
			inverseJoinColumns = {@JoinColumn(name="fee_id")}
			)
	private Set<FeeLog> feelog = new HashSet<>();

	public Course() {
		super();
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getCourseTitle() {
		return CourseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		CourseTitle = courseTitle;
	}

	public int getCreditHours() {
		return CreditHours;
	}

	public void setCreditHours(int creditHours) {
		CreditHours = creditHours;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

//	public List<Instructor> getInstructor() {
//		return instructor;
//	}
//
//	public void setInstructor(List<Instructor> instructor) {
//		this.instructor = instructor;
//	}
//
//	public List<Student> getStudent() {
//		return student;
//	}
//
//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}
//
//	public List<FeeLog> getFeelog() {
//		return feelog;
//	}
//
//	public void setFeelog(List<FeeLog> feelog) {
//		this.feelog = feelog;
//	}

	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", CourseTitle=" + CourseTitle + ", CreditHours=" + CreditHours
				+ ", department=" + department + ", instructor=" + instructor + ", student=" + student + ", feelog="
				+ feelog + "]";
	}

	public Set<Instructor> getInstructor() {
		return instructor;
	}

	public void setInstructor(Set<Instructor> instructor) {
		this.instructor = instructor;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public Set<FeeLog> getFeelog() {
		return feelog;
	}

	public void setFeelog(Set<FeeLog> feelog) {
		this.feelog = feelog;
	}
	
	
}
