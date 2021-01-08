package com.tgi.sms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.model.Building;
import com.tgi.sms.repository.BuildingRepo;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class BuildingInfoControllerCRUD {

	@Autowired
	BuildingRepo brepo;

	@Autowired
	DepartmentRepo deptrepo;

	// Form to add block
	@RequestMapping("/addBlock")
	public String addBlock() {
		return "addBlock.jsp";
	}

	// Add operation
	@RequestMapping("/addingBlock")
	public String addingBlock(Building b) {
		brepo.save(b);
		return "blockadded.jsp";
	}

	// Form to edit a block
	@RequestMapping("/editBlock")
	public String editBlock() {
		return "editBlock.jsp";
	}

	// Edit operation
	@RequestMapping("/editingBlock")
	public String editingBlock(Building b) {
		int id = b.getBuildingId();
		if (brepo.findById(id).isPresent()) {
			Building newb = brepo.findById(b.getBuildingId()).orElse(null);
			newb.setBuildingName(b.getBuildingName());
			newb.setDepartment(b.getDepartment());
			brepo.save(newb);
			return "blockupdated.jsp";
		} else
			return "blocknotfound.jsp";
	}

	// Form to search a block
	@RequestMapping("/searchBlock")
	public String searchBlock() {
		return "searchBlock.jsp";
	}

	// Search operation
	@RequestMapping("/searchingBlock")
	public ModelAndView searchingBlock(int BuildingId) {
		ModelAndView model = new ModelAndView("showBlock.jsp");
		ModelAndView m = new ModelAndView("blocknotfound.jsp");
		if (brepo.findById(BuildingId).isPresent()) {
			model.addObject("building", brepo.findById(BuildingId));
			return model;
		} else
			return m;
	}

	// Form to delete a block
	@RequestMapping("/deleteBlock")
	public String deleteBlock() {
		return "deleteBlock.jsp";
	}

	// Delete operation
	@RequestMapping("deletingBlock")
	public String deletingBlock(int BuildingId) {
		if (brepo.findById(BuildingId).isPresent()) {
			brepo.deleteById(BuildingId);
			return "blockdeleted";
		} else
			return "blocknotfound.jsp";
	}

}
