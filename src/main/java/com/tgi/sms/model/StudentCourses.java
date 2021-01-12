package com.tgi.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_courses")
public class StudentCourses {

	@Id
	@GeneratedValue
	@Column(name = "student_course_id")
	private int StudentCoursesId;

	@Column(name = "stud_id")
	private int StudentId;

	@Column(name = "course_id")
	private int CourseId;

	public StudentCourses() {
		super();
	}

	public int getStudentCoursesId() {
		return StudentCoursesId;
	}

	public void setStudentCoursesId(int studentCoursesId) {
		StudentCoursesId = studentCoursesId;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	@Override
	public String toString() {
		return "StudentCourses [StudentCoursesId=" + StudentCoursesId + ", StudentId=" + StudentId + ", CourseId="
				+ CourseId + "]";
	}

}
