package com.tgi.sms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.model.Department;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class DepartmentInfoControllerCRUD {

	@Autowired
	DepartmentRepo deptrepo;
	
	//Add dept from
	@RequestMapping("/addDepartment")
	public String addDepartment() {
		return "addDept.jsp";
	}

	//Add operation
	@RequestMapping("/addingDepartment")
	public String addingDepartment(Department dept) {
		deptrepo.save(dept);
		return "deptadded.jsp";
	}

	//Edit dept form
	@RequestMapping("/editDepartment")
	public String editDepartment() {
		return "editDept.jsp";
	}

	//Edit operation
	@RequestMapping("/editingDepartment")
	public String editingDepartment(Department d) {
		int id = d.getDepartmentId();
		if (deptrepo.findById(id).isPresent()) {
			Department newd = deptrepo.findById(d.getDepartmentId()).orElse(null);
			newd.setDepartmentName(d.getDepartmentName());
			deptrepo.save(d);
			return "updated.jsp";
		} else
			return "datanotfound.jsp";
	}

	//Search dept form
	@RequestMapping("/searchDepartment")
	public String searchDepartment() {
		return "searchDept.jsp";
	}

	//Search operation
	@RequestMapping("/searchingDepartment")
	public ModelAndView searchingDepartment(int DepartmentId) {
		ModelAndView model = new ModelAndView("showDept.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if (deptrepo.findById(DepartmentId).isPresent()) {
			model.addObject("dept", deptrepo.findById(DepartmentId));
			return model;
		} else
			return m;
	}

	//Delete dept form
	@RequestMapping("/deleteDepartment")
	public String deleteDepartment() {
		return "deleteDept.jsp";
	}

	//Delete operation
	@RequestMapping("/deletingDepartment")
	public String deletingDepartment(int DepartmentId) {
		if (deptrepo.findById(DepartmentId).isPresent()) {
			deptrepo.deleteById(DepartmentId);
			return "datadeleted";
		} else
			return "datanotfound.jsp";
	}
}
