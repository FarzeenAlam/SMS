package com.tgi.sms.resource;

import org.springframework.web.bind.annotation.RequestMapping;

public class InformationController {

	// If choice is Building
	@RequestMapping("/building")
	public String building() {
		return "building.jsp";
	}

	// If choice is course
	@RequestMapping("/course")
	public String course() {
		return "course.jsp";
	}

	// If choice is department
	@RequestMapping("/department")
	public String department() {
		return "department.jsp";
	}

	// If choice is student
	@RequestMapping("/student")
	public String student() {
		return "studentinfo.jsp";
	}

	// If choice is teacher
	@RequestMapping("/teacher")
	public String teacher() {
		return "teacher.jsp";
	}

}
