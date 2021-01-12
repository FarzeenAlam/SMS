package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.bean.ShowCoursesBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Department;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class DepartmentInfoControllerCRUD {

	@Autowired
	DepartmentRepo deptrepo;

	@Autowired
	CourseRepo crepo;

	// Add department from
	@RequestMapping("/addDepartment")
	public String addDepartment() {
		return "addDept.jsp";
	}

	// Edit department form
	@RequestMapping("/editDepartment")
	public String editDepartment() {
		return "editDept.jsp";
	}

	// Search department form
	@RequestMapping("/searchDepartment")
	public String searchDepartment() {
		return "searchDept.jsp";
	}

	// Delete department form
	@RequestMapping("/deleteDepartment")
	public String deleteDepartment() {
		return "deleteDept.jsp";
	}

	// View Courses, department selection form
	@RequestMapping("/searchCourses")
	public ModelAndView searchCourses() {
		ModelAndView model = new ModelAndView("selectdeptforcourses.jsp");
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

	// Add operation
	@RequestMapping("/addingDepartment")
	public String addingDepartment(Department dept) {
		deptrepo.save(dept);
		return "deptadded.jsp";
	}

	// Edit operation
	@RequestMapping("/editingDepartment")
	public String editingDepartment(Department d) {
		int id = d.getDepartmentId();
		if (deptrepo.findById(id).isPresent()) {
			Department newd = deptrepo.findById(d.getDepartmentId()).orElse(null);
			newd.setDepartmentName(d.getDepartmentName());
			deptrepo.save(d);
			return "deptupdated.jsp";
		} else
			return "deptnotfound.jsp";
	}

	// Search operation
	@RequestMapping("/searchingDepartment")
	public ModelAndView searchingDepartment(int DepartmentId) {
		ModelAndView model = new ModelAndView("showDept.jsp");
		ModelAndView m = new ModelAndView("deptnotfound.jsp");
		if (deptrepo.findById(DepartmentId).isPresent()) {
			model.addObject("dept", deptrepo.findById(DepartmentId));
			return model;
		} else
			return m;
	}

	// Delete operation
	@RequestMapping("/deletingDepartment")
	public String deletingDepartment(int DepartmentId) {
		if (deptrepo.findById(DepartmentId).isPresent()) {
			deptrepo.deleteById(DepartmentId);
			return "deptdeleted";
		} else
			return "deptnotfound.jsp";
	}

	// Viewing Courses
	@RequestMapping("/deptselected")
	public ModelAndView deptselected(DepartmentBean b) {
		ModelAndView model = new ModelAndView("showcourses.jsp");
		ModelAndView m = new ModelAndView("deptnotfound.jsp");
		String name = b.getDepartmentName();
		int id = daoClass.getDepartmentId(name);
		List<ShowCoursesBean> returnlist = new ArrayList<ShowCoursesBean>();
		List<Course> courselist = crepo.findAll();
		if(courselist != null) {
			for(int i = 0; i < courselist.size(); i++) {
				Course c = courselist.get(i);
				if(c.getDepartment().getDepartmentId() == id) {
					ShowCoursesBean bean = convertEntityToBean(c);
					returnlist.add(bean);
				}
			}
			model.addObject("courses", returnlist);
			return model;
		}
		else
			return m;
	
	}

	private ShowCoursesBean convertEntityToBean(Course c) {
		ShowCoursesBean bean = new ShowCoursesBean();
		bean.setCourseId(c.getCourseId());
		bean.setCourseTitle(c.getCourseTitle());
		return bean;
	}
}
