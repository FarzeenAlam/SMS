package com.tgi.sms.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
	
	//If choice is fee search, mapping done in Student Controller, Fee Controller along with its CRUD Controller

}
