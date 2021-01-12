package com.tgi.sms.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.model.Department;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class InstructorController {

	//Called the teacher page from the login profile
	//Handles the teacher information as the admin does
	//so same controlling as TeacherInfoControllerCRUD class
	
	@Autowired
	DepartmentRepo deptrepo;
	
	@RequestMapping("gototeacherstart")
	public ModelAndView gototeacherstart() {
		ModelAndView inst = new ModelAndView("instdept.jsp");
		List<Department> dept = deptrepo.findAll();
		List<DepartmentBean> bean = new ArrayList<DepartmentBean>();
		for(Department d : dept) {
			DepartmentBean dob = new DepartmentBean();
			dob.setDepartmentName(d.getDepartmentName());
			dob.setDepartmentId(d.getDepartmentId());
			bean.add(dob);
		}
		System.out.println(bean);
		inst.addObject("dept", bean);
		return inst;
	}
}
