package com.tgi.sms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.model.Admin;
import com.tgi.sms.model.Instructor;
import com.tgi.sms.model.Student;
import com.tgi.sms.repository.AdminRepo;
import com.tgi.sms.repository.InstructorRepo;
import com.tgi.sms.repository.StudentRepo;

@Controller
public class AccountsHandlingCRUD {

	@Autowired
	StudentRepo studrepo;

	@Autowired
	InstructorRepo instrepo;

	@Autowired
	AdminRepo repo;

	//Returning the form to add an account
	@RequestMapping("/add")
	public String addAdmin() {
		return "addform.jsp";
	}

	//Register an account
	@RequestMapping("/register")
	public String Register(Admin admin) {
		String id = admin.getEmail();
		String name = admin.getName();
		if (repo.findById(id).isPresent()) {
			return "error.jsp";
		} else {
			if (admin.getAccountType().equals("Admin")) {
				repo.save(admin);
				return "save.jsp";
			} else if (admin.getAccountType().equals("Student")) {
				Student s = new Student();
				s.setStudentName(name);
				studrepo.save(s);
				repo.save(admin);
				return "save.jsp";
			} else {
				Instructor i = new Instructor();
				instrepo.save(i);
				repo.save(admin);
				return "save.jsp";
			}

		}
	}

	//Form to update the account details
	@RequestMapping("/edit")
	public String edit() {
		return "editform.jsp";
	}

	//Update operation
	@RequestMapping("/update")
	public String update(Admin a) {
		String id = a.getEmail();
		if (repo.findById(id).isPresent()) {
			Admin newAdmin = repo.findById(a.getEmail()).orElse(null);
			newAdmin.setEmail(a.getEmail());
			newAdmin.setName(a.getName());
			newAdmin.setPassword(a.getPassword());
			newAdmin.setAccountType(a.getAccountType());
			repo.save(newAdmin);
			return "updated.jsp";
		} else
			return "nodata.jsp";
	}

	//Form to search an account
	@RequestMapping("/search")
	public String search() {
		return "searchform.jsp";
	}

	//Search operation
	@RequestMapping("/searching")
	public ModelAndView search(String Email) {
		ModelAndView model = new ModelAndView("show.jsp");
		ModelAndView m = new ModelAndView("nodata.jsp");
		if (repo.findById(Email).isPresent()) {
			model.addObject("admin", repo.findById(Email));
			return model;
		} else
			return m;
	}

	//Delete form
	@RequestMapping("delete")
	public String deleting() {
		return "deleteform.jsp";
	}

	//Delete operation
	@RequestMapping("deleted")
	public String delete(String Email) {
		if (repo.findById(Email).isPresent()) {
			repo.deleteById(Email);
			return "deleted.jsp";
		} else
			return "nodata.jsp";
	}
}
