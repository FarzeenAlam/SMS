package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.CourseBean;
import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Department;
import com.tgi.sms.model.Student;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.DepartmentRepo;
import com.tgi.sms.repository.StudentRepo;

@Controller
public class StudentInfoControllerCRUD {

	@Autowired
	StudentRepo studrepo;

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

	@RequestMapping("afterdepartment")
	public String afterdepartment(@ModelAttribute("departmentName") String department) {
		System.out.print(department);
		Department dept = convertBeantoEntity(department);
//		List<CourseBean> returnlist = new ArrayList<CourseBean>();
//		List<Course> courselist = crepo.findAll();
//		for(Course c : courselist) {
//			if(dept.getDepartmentId() == c.getDepartment().getDepartmentId())
//				returnlist.add(c.getCourseTitle());
//		}
		List<Course> getlist = crepo.findAll();
		List<CourseBean> bean = new ArrayList<CourseBean>();
		for(Course c : getlist) {
			CourseBean cb = new CourseBean();
			if(dept.getDepartmentId() == c.getDepartment().getDepartmentId()) {
			cb.setCourseTitle(c.getCourseTitle());
			bean.add(cb);
			}
		}
		System.out.println(bean);

		return "studentinfo.jsp";
	}

	private Department convertBeantoEntity(String dept) {
		String name = dept;
		Department department = new Department();
		List<Department> list = deptrepo.findAll();
		for(Department d : list) {
			if(d.getDepartmentName().equals(name)) {
				department.setDepartmentId(d.getDepartmentId());
				department.setDepartmentName(d.getDepartmentName());
			}
		}
		return department;
	}

	private List<Course> getCourses(DepartmentBean departmentName) {
		Department dept = deptrepo.findById(departmentName.getDepartmentId()).orElse(null);
		List<Course> returnlist = new ArrayList<Course>();
		List<Course> courselist = crepo.findAll();
		for(Course c : courselist) {
			if(c.getDepartment().getDepartmentId() == dept.getDepartmentId())
				returnlist.add(c);
		}
		System.out.print(returnlist);
		return returnlist;
	}


	// Add student form
	@RequestMapping("/addStudent")
	public ModelAndView addStudent() {
//		String name = departmentName;
//
//		List<Department> deptlist = deptrepo.findAll();
//		Department dept = new Department();
//		for(Department d : deptlist) {
//			if(d.getDepartmentName().equals(name))
//				dept = d;
//		}
		// Department obj = daoClass.findDepartmentId(departmentName);
		// deptid = obj.getDepartmentId();
		List<Course> courselist = getCourses(getDeptbean());
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
	public String addingstudent(Student s) {
//		Department dept = deptrepo.findById(getDeptid()).orElse(null);
//		s.setDepartment(dept);
		studrepo.save(s);
		return "dataadded.jsp";
	}

	// Edit student form
	@RequestMapping("/editStudent")
	public ModelAndView editStudent() {
	//	List<Course> courselist = daoClass.findCoursebyDeptId(getDeptid());
		ModelAndView model = new ModelAndView("editstudent.jsp");
		List<CourseBean> bean = new ArrayList<CourseBean>();
//		for (Course c : courselist) {
//			CourseBean cb = new CourseBean();
//			cb.setCourseTitle(c.getCourseTitle());
//			bean.add(cb);
//		}
		System.out.println(bean);
		model.addObject("courses", bean);
		return model;
	}

	// Edit operation
	@RequestMapping("/editingStudent")
	public String editingStudent(Student s) {
//		Department dept = deptrepo.findById(deptid).orElse(null);
	//	s.setDepartment(dept);
		int id = s.getStudentId();
		if (studrepo.findById(id).isPresent()) {
			Student news = studrepo.findById(s.getStudentId()).orElse(null);
			news.setStudentStatus(s.StudentStatus);
			news.setStudentName(s.getStudentName());
			news.setDepartment(s.getDepartment());
			news.setCourse(s.getCourse());
			studrepo.save(s);
			return "updated.jsp";
		} else
			return "datanotfound.jsp";
	}

	// Search student form
	@RequestMapping("/searchStudent")
	public String searchStudent(DepartmentBean dept) {
		return "searchstudent.jsp";
	}

	// Search operation
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

	// Delete student form
	@RequestMapping("/deleteStudent")
	public String deleteStudent(DepartmentBean dept) {
		return "deletestudent.jsp";
	}

	// Delete operation
	@RequestMapping("/deletingStudent")
	public String deletingStudent(int StudentId) {
		if (studrepo.findById(StudentId).isPresent()) {
			studrepo.deleteById(StudentId);
			return "datadeleted";
		} else
			return "datanotfound.jsp";
	}

}
