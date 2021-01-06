package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.model.Department;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class InformationController {
	
	@Autowired
	DepartmentRepo deptrepo;


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
	public ModelAndView student() {
		ModelAndView model = new ModelAndView("selectdepartment.jsp");
		List<Department> dept = deptrepo.findAll();
		List<DepartmentBean> bean = new ArrayList<DepartmentBean>();
		for(Department d : dept) {
			DepartmentBean dob = new DepartmentBean();
			dob.setDepartmentName(d.getDepartmentName());
			dob.setDepartmentId(d.getDepartmentId());
			bean.add(dob);
		}
		System.out.println(bean);
		model.addObject("dept", bean);
		return model;
	}

	// If choice is teacher
	@RequestMapping("/teacher")
	public String teacher() {
		return "teacher.jsp";
	}

}
