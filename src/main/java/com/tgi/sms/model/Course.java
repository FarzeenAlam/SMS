package com.tgi.sms.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	
	@OneToMany(mappedBy = "course")
	private List<Instructor> instructor;
	
	@ManyToOne
	@JoinColumn(name="stud_id")
	private Student student;

	@OneToMany(mappedBy = "course")
	private List<StudentFeeLog> studentfeelog;

	public Student getStudent() {
		return student;
	}

	public List<Instructor> getInstructor() {
		return instructor;
	}

	public void setInstructor(List<Instructor> instructor) {
		this.instructor = instructor;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

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

	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", CourseTitle=" + CourseTitle + ", CreditHours=" + CreditHours
				+ ", department=" + department + ", instructor=" + instructor + ", student=" + student + "]";
	}

}
