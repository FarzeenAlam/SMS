package com.tgi.sms.bean;

public class CourseBean {
	private String courseTitle;
	private Boolean courseStatus;

	public Boolean getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(Boolean courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	@Override
	public String toString() {
		return "CourseBean [courseTitle=" + courseTitle + ", courseStatus=" + courseStatus + "]";
	}

}
