package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.CourseBean;
import com.tgi.sms.bean.StudentIDBean;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Student;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.StudentRepo;

@Controller
public class StudentController {

	// Student Control

	@Autowired
	CourseRepo crepo;
	
	@Autowired
	StudentRepo studrepo;

	@RequestMapping("gotostudentstart")
	public String backtostart() {
		return "student1.jsp";
	}

	// Add fee fee form
	@RequestMapping("/addFee")
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("addfeestudentid.jsp");
		List<StudentIDBean> ids = new ArrayList<StudentIDBean>();
		List<Student> student = studrepo.findAll();
		for(int i = 0; i < student.size(); i++) {
			StudentIDBean bean = new StudentIDBean();
			bean.setStudentId(student.get(i).StudentId);
			ids.add(bean);
		}
//		return "addfee.jsp";
		model.addObject("ids", ids);
		return model;
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

}
