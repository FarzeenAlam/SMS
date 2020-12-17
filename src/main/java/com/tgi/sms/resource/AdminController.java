package com.tgi.sms.resource;

import org.springframework.web.bind.annotation.RequestMapping;

public class AdminController {

	// Logged in from Login Controller

	// If choice is account handling
	@RequestMapping("/accounts")
	public String accounts() {
		return "admin1.jsp";
	}

	// If choice is information handling
	@RequestMapping("/information")
	public String information() {
		return "infoform.jsp";
	}

}
