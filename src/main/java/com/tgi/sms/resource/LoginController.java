package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.model.Admin;
import com.tgi.sms.model.Department;
import com.tgi.sms.repository.AdminRepo;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class LoginController {

	@Autowired
	AdminRepo repo;
	
	@Autowired
	DepartmentRepo deptrepo;

	// login credentials will be checked here
	@RequestMapping("/login")
	public ModelAndView Login(Admin admin) {
		ModelAndView adminpage = new ModelAndView("admin.jsp");
		ModelAndView student = new ModelAndView("student1.jsp");
		ModelAndView inst = new ModelAndView("instdept.jsp");
		ModelAndView wpwd = new ModelAndView("pwderror.jsp");
		ModelAndView wdata = new ModelAndView("wrongdata.jsp");

		String id = admin.getEmail();
		String pwd = admin.getPassword();
		if (repo.findById(id).isPresent()) {
			Admin ad = repo.findById(id).orElse(null);
			if (ad.getPassword().equals(pwd)) {
				if (ad.getAccountType().equals("Admin"))
					return adminpage;
				else if (ad.getAccountType().equals("Student"))
					return student;
				else {
					List<Department> dept = deptrepo.findAll();
					List<DepartmentBean> bean = new ArrayList<DepartmentBean>();
					for(Department d : dept) {
						DepartmentBean dob = new DepartmentBean();
						dob.setDepartmentName(d.getDepartmentName());
						dob.setDepartmentId(d.getDepartmentId());
						bean.add(dob);
					}
					System.out.println(bean);
					inst.addObject("dept", bean);
					return inst;
					}
				
			}

			else
				return wpwd;
		} else
			return wdata;
	}
	
	//On Return button from invalid login entry
	@RequestMapping("/back")
	public String back() {
		return "Main.jsp";
	}
}
