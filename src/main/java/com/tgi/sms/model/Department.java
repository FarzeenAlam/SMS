package com.tgi.sms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue
	@Column(name = "dept_id")
	private int DepartmentId;

	@Column(name = "dept_name")
	private String DepartmentName;

	@OneToOne(mappedBy = "department")
	private Building building;

	@OneToMany(mappedBy = "department")
	private List<Course> course;

	@OneToMany(mappedBy = "department")
	private List<Instructor> instructor;

	@OneToMany(mappedBy = "department")
	private List<Student> student;

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

	@Override
	public String toString() {
		return "Department [DepartmentId=" + DepartmentId + ", DepartmentName=" + DepartmentName + "]";
	}

}
