package com.tgi.sms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id
	@GeneratedValue
	@Column(name="inst_id")
	public int InstructorId;
	
	@Column(name="inst_name")
	public String InstructorName;
	
	@Column(name="salary")
	public float Salary;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	public Department department;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	@ManyToOne
	@JoinColumn(name="stud_id")
	private Student student;

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setStudent(Student student) {
		this.student = student;
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
				+ ", department=" + department + ", course=" + course + ", student=" + student + "]";
	}

	
}
