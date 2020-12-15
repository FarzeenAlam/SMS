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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id")
	public Department department;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
			name="instructor_course",
			joinColumns = {@JoinColumn(name="inst_id")},
			inverseJoinColumns = {@JoinColumn(name="course_id")}
			)
	private Set<Course> course = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
			name="instructor_student",
			joinColumns = {@JoinColumn(name="inst_id")},
			inverseJoinColumns = {@JoinColumn(name="stud_id")}
			)
	private Set<Student> student = new HashSet<>();


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


//	public List<Course> getCourse() {
//		return course;
//	}
//
//
//	public void setCourse(List<Course> course) {
//		this.course = course;
//	}
//
//
//	public List<Student> getStudent() {
//		return student;
//	}
//
//
//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}


	@Override
	public String toString() {
		return "Instructor [InstructorId=" + InstructorId + ", InstructorName=" + InstructorName + ", Salary=" + Salary
				+ ", department=" + department + ", course=" + course + ", student=" + student + "]";
	}


	public Set<Course> getCourse() {
		return course;
	}


	public void setCourse(Set<Course> course) {
		this.course = course;
	}


	public Set<Student> getStudent() {
		return student;
	}


	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	
	
}
