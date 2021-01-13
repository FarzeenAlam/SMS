package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.CourseBean;
import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.bean.InstructorIDBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Department;
import com.tgi.sms.model.Instructor;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.DepartmentRepo;
import com.tgi.sms.repository.InstructorRepo;

@Controller
public class TeacherInfoControllerCRUD {

	@Autowired
	InstructorRepo instrepo;
	@Autowired
	CourseRepo crepo;

	@Autowired
	DepartmentRepo deptrepo;

	private DepartmentBean deptbean;

	public DepartmentBean getDeptbean() {
		return deptbean;
	}

	public void setDeptbean(DepartmentBean deptbean) {
		this.deptbean = deptbean;
	}

	@RequestMapping("teacherhandler")
	public String afterdepartment(DepartmentBean bean) {
		String name = bean.getDepartmentName();
		int id = daoClass.getDepartmentId(name);
		DepartmentBean depbean = new DepartmentBean();
		depbean.setDepartmentId(id);
		depbean.setDepartmentName(name);
		System.out.print(depbean);
		setDeptbean(depbean);
		System.out.print(deptbean);
		return "teacher.jsp";
	}

	private List<Course> getCourses(DepartmentBean dep) {
		List<Course> returnlist = new ArrayList<Course>();
		List<Course> courselist = crepo.findAll();
		for (Course c : courselist) {
			if (c.getDepartment().getDepartmentId() == dep.getDepartmentId())
				returnlist.add(c);
		}
		System.out.print(returnlist);
		return returnlist;
	}

	// RETURN TEACHER FORMS
	// Add teacher form
	@RequestMapping("/addTeacher")
	public ModelAndView addTeacher() {
		List<Course> courselist = getCourses(deptbean);
		System.out.print("RETURNED LIST" + courselist);
		ModelAndView model = new ModelAndView("addTeacher.jsp");
		List<CourseBean> bean = new ArrayList<CourseBean>();
		for (Course c : courselist) {
			CourseBean cb = new CourseBean();
			cb.setCourseTitle(c.getCourseTitle());
			bean.add(cb);
		}
		System.out.println(bean);
		model.addObject("courses", bean);
		return model;
	}

	// Edit teacher form
	@RequestMapping("/editTeacher")
	public ModelAndView editTeacher() {
		List<Course> courselist = getCourses(deptbean);
		ModelAndView model = new ModelAndView("editTeacher.jsp");
		List<CourseBean> bean = new ArrayList<CourseBean>();
		for (Course c : courselist) {
			CourseBean cb = new CourseBean();
			cb.setCourseTitle(c.getCourseTitle());
			bean.add(cb);
		}
		System.out.println(bean);
		model.addObject("courses", bean);
		return model;
	}

	// Search teacher form
	@RequestMapping("/searchTeacher")
	public ModelAndView searchTeacher() {
		ModelAndView model = new ModelAndView("searchTeacher.jsp");
		List<Instructor> instructor = instrepo.findAll();
		List<InstructorIDBean> ibean = new ArrayList<InstructorIDBean>();
		DepartmentBean dbean = getDeptbean();
		for (Instructor i : instructor) {
			if (i.getDepartment().getDepartmentId() == dbean.getDepartmentId()) {
				InstructorIDBean bean = new InstructorIDBean();
				bean.setInstructorId(i.getInstructorId());
				ibean.add(bean);
			}
		}
		System.out.println(ibean);
		model.addObject("courses", ibean);
		return model;
	}

	// Delete teacher form
	@RequestMapping("/deleteTeacher")
	public ModelAndView deleteTeacher() {
		ModelAndView model = new ModelAndView("deleteTeacher.jsp");
		List<Instructor> instructor = instrepo.findAll();
		List<InstructorIDBean> ibean = new ArrayList<InstructorIDBean>();
		for (Instructor i : instructor) {
			if (i.getDepartment().getDepartmentId() == deptbean.getDepartmentId()) {
				InstructorIDBean bean = new InstructorIDBean();
				bean.setInstructorId(i.getInstructorId());
				ibean.add(bean);
			}
		}
		System.out.println(ibean);
		model.addObject("courses", ibean);
		return model;
	}

	// OPERATIONS
	// Add operation
	@RequestMapping("/addingTeacher")
	public String addingTeacher(Instructor inst, CourseBean b) {
		String name = b.getCourseTitle();
		Course course = daoClass.getCoursebyName(name);
		Department dept = convertBeantoEntity(deptbean);
		inst.setCourse(course);
		inst.setDepartment(dept);
		instrepo.save(inst);
		return "teacheradded.jsp";
	}

	// Edit operation
	@RequestMapping("/editingTeacher")
	public String editingTeacher(Instructor inst, CourseBean b) {
		int id = inst.getInstructorId();
		Department dept = convertBeantoEntity(deptbean);
		inst.setDepartment(dept);
		String name = b.getCourseTitle();
		Course course = daoClass.getCoursebyName(name);
		inst.setCourse(course);
		if (instrepo.findById(id).isPresent()) {
			Instructor newinst = instrepo.findById(inst.getInstructorId()).orElse(null);
			newinst.setInstructorName(inst.getInstructorName());
			newinst.setSalary(inst.getSalary());
			newinst.setDepartment(inst.getDepartment());
			newinst.setCourse(inst.getCourse());
			instrepo.save(newinst);
			return "teacherupdated.jsp";
		} else
			return "teachernotfound.jsp";
	}

	// Search operation
	@RequestMapping("/searchingTeacher")
	public ModelAndView searchingTeacher(InstructorIDBean b) {
		int InstructorId = b.getInstructorId();
		ModelAndView model = new ModelAndView("showTeacher.jsp");
		ModelAndView m = new ModelAndView("teachernotfound.jsp");
		if (instrepo.findById(InstructorId).isPresent()) {
			model.addObject("instructor", instrepo.findById(InstructorId));
			return model;
		} else
			return m;
	}

	// Delete operation
	@RequestMapping("/deletingTeacher")
	public String deletingTeacher(InstructorIDBean b) {
		int InstructorId = b.getInstructorId();
		if (instrepo.findById(InstructorId).isPresent()) {
			instrepo.deleteById(InstructorId);
			return "teacherdeleted.jsp";
		} else
			return "teachernotfound.jsp";
	}
	
	private Department convertBeantoEntity(DepartmentBean deptbean2) {
		Department d = new Department();
		d.setDepartmentId(deptbean2.getDepartmentId());
		d.setDepartmentName(deptbean2.getDepartmentName());
		return d;
	}
}
