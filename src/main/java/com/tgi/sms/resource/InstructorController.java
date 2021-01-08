package com.tgi.sms.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InstructorController {

	//Called the teacher page from the login profile
	//Handles the teacher information as the admin does
	//so same controlling as TeacherInfoControllerCRUD class
	
	@RequestMapping("gototeacherstart")
	public String gototeacherstart() {
		return "instdept.jsp";
	}
}
