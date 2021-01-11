package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Department;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class CourseInfoControllerCRUD {

	@Autowired
	CourseRepo crepo;

	@Autowired
	DepartmentRepo deptrepo;

	// RETURN FORMS
	// Add course
	@RequestMapping("/addCourse")
	public ModelAndView addCourse() {
		ModelAndView model = new ModelAndView("addCourse.jsp");
		List<Department> dept = deptrepo.findAll();
		List<DepartmentBean> bean = new ArrayList<DepartmentBean>();
		for (Department d : dept) {
			DepartmentBean dob = new DepartmentBean();
			dob.setDepartmentName(d.getDepartmentName());
			dob.setDepartmentId(d.getDepartmentId());
			bean.add(dob);
		}
		System.out.println(bean);
		model.addObject("dept", bean);
		return model;
	}

	// Edit course
	@RequestMapping("/editCourse")
	public ModelAndView editCourse() {
		ModelAndView model = new ModelAndView("editCourse.jsp");
		List<Department> dept = deptrepo.findAll();
		List<DepartmentBean> bean = new ArrayList<DepartmentBean>();
		for (Department d : dept) {
			DepartmentBean dob = new DepartmentBean();
			dob.setDepartmentName(d.getDepartmentName());
			dob.setDepartmentId(d.getDepartmentId());
			bean.add(dob);
		}
		System.out.println(bean);
		model.addObject("dept", bean);
		return model;
	}

	// Search course form
	@RequestMapping("/searchCourse")
	public String searchCourse() {
		return "searchCourse.jsp";
	}

	// Delete course form
	@RequestMapping("/deleteCourse")
	public String deleteCourse() {
		return "deleteCourse.jsp";
	}

	// OPERATIONS
	// Add operation
	@RequestMapping("/addingCourse")
	public String addingCourse(Course c, DepartmentBean bean) {
		String name = bean.getDepartmentName();
		int id = daoClass.getDepartmentId(name);
		DepartmentBean depbean = new DepartmentBean();
		depbean.setDepartmentId(id);
		depbean.setDepartmentName(name);
		Department dept = convertBeantoEntity(depbean);
		c.setDepartment(dept);
		crepo.save(c);
		return "courseadded.jsp";
	}

	// Edit operation
	@RequestMapping("/editingCourse")
	public String editingCourse(Course c, DepartmentBean bean) {
		String name = bean.getDepartmentName();
		int id = daoClass.getDepartmentId(name);
		DepartmentBean depbean = new DepartmentBean();
		depbean.setDepartmentId(id);
		depbean.setDepartmentName(name);
		Department dept = convertBeantoEntity(depbean);
		c.setDepartment(dept);
		int cid = c.getCourseId();
		if (crepo.findById(cid).isPresent()) {
			Course newc = crepo.findById(c.getCourseId()).orElse(null);
			newc.setCourseTitle(c.getCourseTitle());
			newc.setCreditHours(c.getCreditHours());
			newc.setDepartment(c.getDepartment());
			crepo.save(c);
			return "courseupdated.jsp";
		} else
			return "coursenotfound.jsp";
	}

	// Search operation
	@RequestMapping("/searchingCourse")
	public ModelAndView searchingCourse(int CourseId) {
		ModelAndView model = new ModelAndView("showCourse.jsp");
		ModelAndView m = new ModelAndView("coursenotfound.jsp");
		if (crepo.findById(CourseId).isPresent()) {
			model.addObject("course", crepo.findById(CourseId));
			return model;
		} else
			return m;
	}

	// Delete operation
	@RequestMapping("/deletingCourse")
	public String deletingCourse(int CourseId) {
		if (crepo.findById(CourseId).isPresent()) {
			crepo.deleteById(CourseId);
			return "coursedeleted";
		} else
			return "coursenotfound.jsp";
	}
	
	private Department convertBeantoEntity(DepartmentBean depbean) {
		Department d = new Department();
		d.setDepartmentId(depbean.getDepartmentId());
		d.setDepartmentName(depbean.getDepartmentName());
		return d;
	}

}
