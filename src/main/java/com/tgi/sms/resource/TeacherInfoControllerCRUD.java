package com.tgi.sms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.model.Instructor;
import com.tgi.sms.repository.InstructorRepo;

@Controller
public class TeacherInfoControllerCRUD {

	@Autowired
	InstructorRepo instrepo;

	// Teacher Profile
	// Add teacher form
	@RequestMapping("/addTeacher")
	public String addTeacher() {
		return "addTeacher.jsp";
	}

	// Add operation
	@RequestMapping("/addingTeacher")
	public String addingTeacher(Instructor inst) {
		instrepo.save(inst);
		return "teacheradded.jsp";
	}

	// Edit teacher form
	@RequestMapping("/editTeacher")
	public String editTeacher() {
		return "editTeacher.jsp";
	}

	// Edit operation
	@RequestMapping("/editingTeacher")
	public String editingTeacher(Instructor inst) {
		int id = inst.getInstructorId();
		if (instrepo.findById(id).isPresent()) {
			Instructor newinst = instrepo.findById(inst.getInstructorId()).orElse(null);
			newinst.setInstructorName(inst.getInstructorName());
			newinst.setSalary(inst.getSalary());
			newinst.setDepartment(inst.getDepartment());
			instrepo.save(newinst);
			return "updated.jsp";
		} else
			return "datanotfound.jsp";
	}

	// Search teacher form
	@RequestMapping("/searchTeacher")
	public String searchTeacher() {
		return "searchTeacher.jsp";
	}

	// Search operation
	@RequestMapping("/searchingTeacher")
	public ModelAndView searchingTeacher(int InstructorId) {
		ModelAndView model = new ModelAndView("showTeacher.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if (instrepo.findById(InstructorId).isPresent()) {
			model.addObject("instructor", instrepo.findById(InstructorId));
			return model;
		} else
			return m;
	}

	// Delete teacher form
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher() {
		return "deleteTeacher.jsp";
	}

	// Delete operation
	@RequestMapping("/deletingTeacher")
	public String deletingTeacher(int InstructorId) {
		if (instrepo.findById(InstructorId).isPresent()) {
			instrepo.deleteById(InstructorId);
			return "datadeleted.jsp";
		} else
			return "datanotfound.jsp";
	}
}
