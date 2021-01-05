package com.tgi.sms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.model.Course;
import com.tgi.sms.repository.CourseRepo;

@Controller
public class CourseInfoControllerCRUD {

	@Autowired
	CourseRepo crepo;

	//Add course form
	@RequestMapping("/addCourse")
	public String addCourse() {
		return "addCourse.jsp";
	}

	//Add operation
	@RequestMapping("/addingCourse")
	public String addingCourse(Course c) {
		crepo.save(c);
		return "dataadded.jsp";
	}

	//Edit course form
	@RequestMapping("/editCourse")
	public String editCourse() {
		return "editCourse.jsp";
	}

	//Edit operation
	@RequestMapping("/editingCourse")
	public String editingCourse(Course c) {
		int id = c.getCourseId();
		if (crepo.findById(id).isPresent()) {
			Course newc = crepo.findById(c.getCourseId()).orElse(null);
			newc.setCourseStatus(c.CourseStatus);
			newc.setCourseTitle(c.getCourseTitle());
			newc.setCreditHours(c.getCreditHours());
			newc.setDepartment(c.getDepartment());
			crepo.save(c);
			return "updated.jsp";
		} else
			return "datanotfound.jsp";
	}

	//Search course form
	@RequestMapping("/searchCourse")
	public String searchCourse() {
		return "searchCourse.jsp";
	}

	//Search operation
	@RequestMapping("/searchingCourse")
	public ModelAndView searchingCourse(int CourseId) {
		ModelAndView model = new ModelAndView("showCourse.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if (crepo.findById(CourseId).isPresent()) {
			model.addObject("course", crepo.findById(CourseId));
			return model;
		} else
			return m;
	}

	//Delete course form
	@RequestMapping("/deleteCourse")
	public String deleteCourse() {
		return "deleteCourse.jsp";
	}

	//Delete operation
	@RequestMapping("/deletingCourse")
	public String deletingCourse(int CourseId) {
		if (crepo.findById(CourseId).isPresent()) {
			crepo.deleteById(CourseId);
			return "datadeleted";
		} else
			return "datanotfound.jsp";
	}

}
