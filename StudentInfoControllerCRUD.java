package com.tgi.sms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.model.Student;
import com.tgi.sms.repository.StudentRepo;

public class StudentInfoControllerCRUD {

	@Autowired
	StudentRepo studrepo;

	//Add student form
	@RequestMapping("/addStudent")
	public String addStudent() {
		return "addstudent.jsp";
	}

	//Add operation
	@RequestMapping("/addingStudent")
	public String addingstudent(Student s) {
		studrepo.save(s);
		return "dataadded.jsp";
	}

	//Edit student form
	@RequestMapping("/editStudent")
	public String editStudent() {
		return "editstudent.jsp";
	}

	//Edit operation
	@RequestMapping("/editingStudentent")
	public String editingStudent(Student s) {
		int id = s.getStudentId();
		if (studrepo.findById(id).isPresent()) {
			Student news = studrepo.findById(s.getStudentId()).orElse(null);
			news.setStudentName(s.getStudentName());
			news.setDepartment(s.getDepartment());
			studrepo.save(s);
			return "updated.jsp";
		} else
			return "datanotfound.jsp";
	}

	//Search student form
	@RequestMapping("/searchStudent")
	public String searchStudent() {
		return "searchstudent.jsp";
	}

	//Search operation
	@RequestMapping("/searchingStudent")
	public ModelAndView searchingStudent(int StudentId) {
		ModelAndView model = new ModelAndView("showstudent.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if (studrepo.findById(StudentId).isPresent()) {
			model.addObject("dept", studrepo.findById(StudentId));
			return model;
		} else
			return m;
	}

	//Delete student form
	@RequestMapping("/deleteStudent")
	public String deleteStudent() {
		return "deletestudent.jsp";
	}

	//Delete operation
	@RequestMapping("/deletingStudent")
	public String deletingStudent(int StudentId) {
		if (studrepo.findById(StudentId).isPresent()) {
			studrepo.deleteById(StudentId);
			return "datadeleted";
		} else
			return "datanotfound.jsp";
	}

}
