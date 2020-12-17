package com.tgi.sms.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	// Student Control
	
	//Add fee fee form
	@RequestMapping("/addFee")
	public String add() {
		return "addfee.jsp";
	}
	
	//Edit fee form
	@RequestMapping("/editFee")
	public String editFee() {
		return "editFee.jsp";
	}
	
	//Search fee form
	@RequestMapping("/searchFee")
	public String searchFee() {
		return "searchFee.jsp";
	}
	
	//Delete fee form
	@RequestMapping("/deleteFee")
	public String deleteFee() {
		return "deleteFee.jsp";
	}
	
}
