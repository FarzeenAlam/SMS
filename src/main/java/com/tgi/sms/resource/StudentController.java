package com.tgi.sms.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	// Student Control
	
	@RequestMapping("gotostudentstart")
	public String backtostart() {
		return "student1.jsp";
	}
	
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
	
	//Finding fee record against invoice no
	@RequestMapping("/check")
	public String check() {
		return "getinvoice.jsp";
	}
	
}
