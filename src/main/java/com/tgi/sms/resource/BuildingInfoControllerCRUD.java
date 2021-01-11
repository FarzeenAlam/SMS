package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Building;
import com.tgi.sms.model.Department;
import com.tgi.sms.repository.BuildingRepo;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class BuildingInfoControllerCRUD {

	@Autowired
	BuildingRepo brepo;

	@Autowired
	DepartmentRepo deptrepo;

	// RETURN FORMS
	// add block
	@RequestMapping("/addBlock")
	public ModelAndView addBlock() {
		ModelAndView model = new ModelAndView("addBlock.jsp");
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
	
	// edit a block
	@RequestMapping("/editBlock")
	public ModelAndView editBlock() {
		ModelAndView model = new ModelAndView("editBlock.jsp");
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
	
	// search a block
	@RequestMapping("/searchBlock")
	public String searchBlock() {
		return "searchBlock.jsp";
	}
	
	// delete a block
	@RequestMapping("/deleteBlock")
	public String deleteBlock() {
		return "deleteBlock.jsp";
	}

	// OPERATIONS
	// Add operation
	@RequestMapping("/addingBlock")
	public String addingBlock(Building b, DepartmentBean bean) {
		String name = bean.getDepartmentName();
		int id = daoClass.getDepartmentId(name);
		DepartmentBean depbean = new DepartmentBean();
		depbean.setDepartmentId(id);
		depbean.setDepartmentName(name);
		Department dept = convertBeantoEntity(depbean);
		b.setDepartment(dept);
		brepo.save(b);
		return "blockadded.jsp";
	}

	// Edit operation
	@RequestMapping("/editingBlock")
	public String editingBlock(Building b, DepartmentBean bean) {
		String name = bean.getDepartmentName();
		int id = daoClass.getDepartmentId(name);
		DepartmentBean depbean = new DepartmentBean();
		depbean.setDepartmentId(id);
		depbean.setDepartmentName(name);
		Department dept = convertBeantoEntity(depbean);
		b.setDepartment(dept);
		int bid = b.getBuildingId();
		if (brepo.findById(bid).isPresent()) {
			Building newb = brepo.findById(b.getBuildingId()).orElse(null);
			newb.setBuildingName(b.getBuildingName());
			newb.setDepartment(b.getDepartment());
			brepo.save(newb);
			return "blockupdated.jsp";
		} else
			return "blocknotfound.jsp";
	}

	// Search operation
	@RequestMapping("/searchingBlock")
	public ModelAndView searchingBlock(String BuildingName) {
		ModelAndView model = new ModelAndView("showBlock.jsp");
		ModelAndView m = new ModelAndView("blocknotfound.jsp");
		Building b = daoClass.findBuildingbyName(BuildingName);
		int id = b.getBuildingId();
		if (brepo.findById(id).isPresent()) {
			model.addObject("building", brepo.findById(id));
			return model;
		} else
			return m;
	}

	// Delete operation
	@RequestMapping("deletingBlock")
	public String deletingBlock(String BuildingName) {
		Building b = daoClass.findBuildingbyName(BuildingName);
		int id = b.getBuildingId();
		if (brepo.findById(id).isPresent()) {
			brepo.deleteById(id);
			return "blockdeleted";
		} else
			return "blocknotfound.jsp";
	}
	
	private Department convertBeantoEntity(DepartmentBean depbean) {
		Department d = new Department();
		d.setDepartmentId(depbean.getDepartmentId());
		d.setDepartmentName(depbean.getDepartmentName());
		return d;
	}
	
	

}
