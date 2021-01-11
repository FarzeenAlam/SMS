package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.CourseBean;
import com.tgi.sms.model.Course;
import com.tgi.sms.repository.CourseRepo;

@Controller
public class StudentController {

	// Student Control

	@Autowired
	CourseRepo crepo;

	@RequestMapping("gotostudentstart")
	public String backtostart() {
		return "student1.jsp";
	}

	// Add fee fee form
	@RequestMapping("/addFee")
	public String add() {
		return "addfee.jsp";
	}

	// Edit fee form
	@RequestMapping("/editFee")
	public String editFee() {
		return "editFee.jsp";
	}

	// Search fee form
	@RequestMapping("/searchFee")
	public String searchFee() {
		return "selectfeesearch.jsp";
	}

	// If choice is to search by id
	@RequestMapping("/byID")
	public String byID() {
		return "searchFee.jsp";
	}

	// If choice is to search by invoice
	@RequestMapping("/byInvoice")
	public String byInvoice() {
		return "getinvoice.jsp";
	}

	// If choice is to search by date
	@RequestMapping("/byDate")
	public String datesearch() {
		return "dateentry.jsp";
	}

	// If choice is to search by status
	@RequestMapping("/byStatus")
	public ModelAndView status() {
		ModelAndView model = new ModelAndView("statuspage.jsp");
		List<Course> getlist = crepo.findAll();
		List<CourseBean> bean = new ArrayList<CourseBean>();
		for (Course c : getlist) {
			CourseBean cb = new CourseBean();
			cb.setCourseTitle(c.getCourseTitle());
			bean.add(cb);
		}
		System.out.println(bean);
		model.addObject("courses", bean);
		return model;
	}

	// Delete fee form
	@RequestMapping("/deleteFee")
	public String deleteFee() {
		return "deleteFee.jsp";
	}

	// Finding fee record against invoice no
	@RequestMapping("/check")
	public String check() {
		return "getinvoice.jsp";
	}

}
