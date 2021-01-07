package com.tgi.sms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id
	@GeneratedValue
	@Column(name="inst_id")
	private int InstructorId;
	
	@Column(name="inst_name")
	private String InstructorName;
	
	@Column(name="salary")
	private float Salary;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	
	@OneToOne
	@JoinColumn(name="course_id", referencedColumnName = "course_id")
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Instructor() {
		super();
	}

	public int getInstructorId() {
		return InstructorId;
	}

	public void setInstructorId(int instructorId) {
		InstructorId = instructorId;
	}

	public String getInstructorName() {
		return InstructorName;
	}

	public void setInstructorName(String instructorName) {
		InstructorName = instructorName;
	}

	public float getSalary() {
		return Salary;
	}

	public void setSalary(float salary) {
		Salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Instructor [InstructorId=" + InstructorId + ", InstructorName=" + InstructorName + ", Salary=" + Salary
				+ ", department=" + department + ", course=" + course + "]";
	}

}
