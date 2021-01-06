package com.tgi.sms.bean;

public class CourseBean {
	private String courseTitle;
	private boolean studentStatus;
	
	
	public boolean isStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(boolean studentStatus) {
		this.studentStatus = studentStatus;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	@Override
	public String toString() {
		return "CourseBean [courseTitle=" + courseTitle + ", studentStatus=" + studentStatus + "]";
	}


}
