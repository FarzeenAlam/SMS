package com.tgi.sms.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue
	@Column(name="dept_id")
	private int DepartmentId;
	
	@Column(name="dept_name")
	private String DepartmentName;
	
	@OneToOne(mappedBy="department")
	private Building building;
	
	@OneToMany(mappedBy="department")
	private Set<Course> course;
	
	@OneToMany(mappedBy="department")
	private Set<Instructor> instructor;
	
	@OneToMany(mappedBy="department")
	private Set<Student> student;

	public Department() {
		super();
	}

	public int getDepartmentId() {
		return DepartmentId;
	}

	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
//
//	public Building getBuilding() {
//		return building;
//	}
//
//	public void setBuilding(Building building) {
//		this.building = building;
//	}
//
//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}
//
//	public Instructor getInstructor() {
//		return instructor;
//	}
//
//	public void setInstructor(Instructor instructor) {
//		this.instructor = instructor;
//	}
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

//	@Override
//	public String toString() {
//		return "Department [DepartmentId=" + DepartmentId + ", DepartmentName=" + DepartmentName + ", building="
//				+ building + ", course=" + course + ", instructor=" + instructor + ", student=" + student + "]";
//	}
//	
	

}
