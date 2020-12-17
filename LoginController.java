package com.tgi.sms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgi.sms.model.Admin;
import com.tgi.sms.repository.AdminRepo;

public class LoginController {

	@Autowired
	AdminRepo repo;

	// login credentials will be checked here
	@RequestMapping("/login")
	public String Login(Admin admin) {
		String id = admin.getEmail();
		String pwd = admin.getPassword();
		if (repo.findById(id).isPresent()) {
			Admin ad = repo.findById(id).orElse(null);
			if (ad.getPassword().equals(pwd)) {
				if (ad.getAccountType().equals("Admin"))
					return "admin.jsp";
				else if (ad.getAccountType().equals("Student"))
					return "student1.jsp";
				else
					return "teacher.jsp";
			}

			else
				return "pwderror.jsp";
		} else
			return "wrongdata.jsp";
	}
}
