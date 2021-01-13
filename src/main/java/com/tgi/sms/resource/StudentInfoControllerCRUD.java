package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.CourseBean;
import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.bean.StudentIDBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Department;
import com.tgi.sms.model.Student;
import com.tgi.sms.model.StudentCourses;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.DepartmentRepo;
import com.tgi.sms.repository.StudentCoursesRepo;
import com.tgi.sms.repository.StudentRepo;

@Controller
public class StudentInfoControllerCRUD {

	@Autowired
	StudentRepo studrepo;

	@Autowired
	CourseRepo crepo;

	@Autowired
	DepartmentRepo deptrepo;

	@Autowired
	StudentCoursesRepo screpo;

	// Object to store the selected department
	private DepartmentBean deptbean;

	public DepartmentBean getDeptbean() {
		return deptbean;
	}

	public void setDeptbean(DepartmentBean deptbean) {
		this.deptbean = deptbean;
	}

	// Department Selection
	@RequestMapping("afterdepartment")
	public String afterdepartment(DepartmentBean bean) {
		String name = bean.getDepartmentName();
		int id = daoClass.getDepartmentId(name);
		DepartmentBean depbean = new DepartmentBean();
		depbean.setDepartmentId(id);
		depbean.setDepartmentName(name);
		System.out.print(depbean);
		setDeptbean(depbean);
		System.out.print(deptbean);

		return "studentinfo.jsp";
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

	// Add student form
	@RequestMapping("/addStudent")
	public ModelAndView addStudent() {
		List<Course> courselist = getCourses(deptbean);
		System.out.print("RETURNED LIST" + courselist);
		ModelAndView model = new ModelAndView("addstudent.jsp");
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

	// Add operation
	@RequestMapping("/addingStudent")
	public String addingstudent(Student s, CourseBean b) {
		Department dept = convertBeantoEntity(deptbean);
		s.setDepartment(dept);
		studrepo.save(s);
		String name = b.getCourseTitle();
		Course c = daoClass.getCoursebyName(name);
		int cid = c.getCourseId();
		int sid = s.getStudentId();
		insertintoSC(sid, cid);
		return "studentadded.jsp";
	}

	private void insertintoSC(int sid, int cid) {
		StudentCourses sc = new StudentCourses();
		sc.setCourseId(cid);
		sc.setStudentId(sid);
		screpo.save(sc);
	}

	private Department convertBeantoEntity(DepartmentBean deptbean2) {
		Department d = new Department();
		d.setDepartmentId(deptbean2.getDepartmentId());
		d.setDepartmentName(deptbean2.getDepartmentName());
		return d;
	}

	// Edit student form
	@RequestMapping("/editStudent")
	public ModelAndView editStudent() {
		List<Course> courselist = getCourses(deptbean);
		ModelAndView model = new ModelAndView("editstudent.jsp");
		List<CourseBean> bean = new ArrayList<CourseBean>();
		for (Course c : courselist) {
			CourseBean cb = new CourseBean();
			cb.setCourseTitle(c.getCourseTitle());
			bean.add(cb);
		}
		List<Student> student = studrepo.findAll();
		List<StudentIDBean> ids = new ArrayList<StudentIDBean>();
		for (Student s : student) {
			if (s.getDepartment().getDepartmentId() == deptbean.getDepartmentId()) {
				StudentIDBean sbean = new StudentIDBean();
				sbean.setStudentId(s.getStudentId());
				ids.add(sbean);
			}
		}
		model.addObject("ids", ids);
		model.addObject("courses", bean);
		return model;
	}

	// Edit operation
	@RequestMapping("/editingStudent")
	public String editingStudent(Student s, CourseBean b, StudentIDBean ib) {
		int id = ib.getStudentId();
		Department dept = convertBeantoEntity(deptbean);
		s.setDepartment(dept);
		String name = b.getCourseTitle();
		Course course = daoClass.getCoursebyName(name);
		int cid = course.getCourseId();
		int sid = s.getStudentId();
		if (studrepo.findById(id).isPresent()) {
			Student news = studrepo.findById(s.getStudentId()).orElse(null);
			news.setStudentStatus(s.StudentStatus);
			news.setStudentName(s.getStudentName());
			news.setDepartment(s.getDepartment());
			studrepo.save(s);
			insertintoSC(sid, cid);
			return "studentupdated.jsp";
		} else
			return "studentnotfound.jsp";
	}

	// Search student form
	@RequestMapping("/searchStudent")
	public ModelAndView searchStudent() {
		ModelAndView model = new ModelAndView("searchstudent.jsp");

		List<Student> student = studrepo.findAll();
		List<StudentIDBean> ids = new ArrayList<StudentIDBean>();
		for (Student s : student) {
			if (s.getDepartment().getDepartmentId() == deptbean.getDepartmentId()) {
				StudentIDBean bean = new StudentIDBean();
				bean.setStudentId(s.getStudentId());
				ids.add(bean);
			}
		}
		System.out.println(ids);
		model.addObject("courses", ids);
		return model;
	}

	// Search operation
	@RequestMapping("/searchingStudent")
	public ModelAndView searchingStudent(StudentIDBean b) {
		int id = b.getStudentId();
		ModelAndView model = new ModelAndView("showstudent.jsp");
		ModelAndView m = new ModelAndView("studentnotfound.jsp");
		if (studrepo.findById(id).isPresent()) {
			model.addObject("student", studrepo.findById(id));
			return model;
		} else
			return m;
	}

	// Delete student form
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent() {
		ModelAndView model = new ModelAndView("deletestudent.jsp");

		List<Student> student = studrepo.findAll();
		List<StudentIDBean> ids = new ArrayList<StudentIDBean>();
		for (Student s : student) {
			if (s.getDepartment().getDepartmentId() == deptbean.getDepartmentId()) {
				StudentIDBean bean = new StudentIDBean();
				bean.setStudentId(s.getStudentId());
				ids.add(bean);
			}
		}
		System.out.println(ids);
		model.addObject("courses", ids);
		return model;
	}

	// Delete operation
	@RequestMapping("/deletingStudent")
	public String deletingStudent(StudentIDBean b) {
		int StudentId = b.getStudentId();
		if (studrepo.findById(StudentId).isPresent()) {
			studrepo.deleteById(StudentId);
			return "studentdeleted.jsp";
		} else
			return "studentnotfound.jsp";
	}
	
	@RequestMapping("/addCourses")
	public ModelAndView addCourses() {
		ModelAndView model = new ModelAndView("addcoursesforstudent.jsp");
		List<Student> student = studrepo.findAll();
		List<StudentIDBean> ids = new ArrayList<StudentIDBean>();
		for (Student s : student) {
			if (s.getDepartment().getDepartmentId() == deptbean.getDepartmentId()) {
				StudentIDBean bean = new StudentIDBean();
				bean.setStudentId(s.getStudentId());
				ids.add(bean);
			}
		}
		System.out.println(ids);
		List<Course> courselist = getCourses(deptbean);
		List<CourseBean> bean = new ArrayList<CourseBean>();
		for (Course c : courselist) {
			CourseBean cb = new CourseBean();
			cb.setCourseTitle(c.getCourseTitle());
			bean.add(cb);
		}
		model.addObject("ids", ids);
		model.addObject("courses", bean);
		return model;
	}
	
	@RequestMapping("/addingcourseforstudent")
	public String addingcourseforstudent(StudentIDBean si, CourseBean b) {
		String name = b.getCourseTitle();
		Course course = daoClass.getCoursebyName(name);
		int cid = course.getCourseId();
		int bid = si.getStudentId();
		boolean ifexists = checkif(bid, cid);
		if(ifexists) {
			return "scexists.jsp";
		}
		else {
			insertintoSC(bid, cid);
			return "scadded.jsp";
		}	
	}

	private boolean checkif(int bid, int cid) {

		boolean flag = false;
		List<StudentCourses> list = screpo.findAll();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getStudentId() == bid && list.get(i).getCourseId() == cid)
				flag = true;
		}
		return flag;
	}

}
