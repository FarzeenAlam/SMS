package com.tgi.sms.resource;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Department;
import com.tgi.sms.model.Student;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class ControllerClass {

	@Autowired
	DepartmentRepo deptrepo;
	//Start of the application
	@RequestMapping("/home")
	public String h() {
		return "Main.jsp";
	}
	
	@RequestMapping("/testcheckbox")
	public ModelAndView testcheck() {
		ModelAndView model = new ModelAndView("testcheckbox.jsp");
		List<Department> dept = deptrepo.findAll();
		List<DepartmentBean> bean = new ArrayList<DepartmentBean>();
		for(Department d : dept) {
			DepartmentBean dob = new DepartmentBean();
			dob.setDepartmentName(d.getDepartmentName());
			dob.setDepartmentId(d.getDepartmentId());
			bean.add(dob);
		}
		model.addObject("dept", bean);
		return model;
	}

	//Test function from daoClass
	@RequestMapping("/sStudent")
	private String searchingStudent(int StudentId) {
		Student student = daoClass.findStudent(StudentId);
		System.out.println(student);
		return "save.jsp";
	}

	// java.time is new for datetime handling, test try here, it worked
	@RequestMapping("/testDate")
	public String testDate(String DateTime) {
		Date today = new Date();
		ZonedDateTime now = ZonedDateTime.now();
		LocalTime truncated = LocalTime.now().truncatedTo(ChronoUnit.HOURS);
		System.out.println(today);
		System.out.println(now);
		System.out.println(truncated);

		return "save.jsp";
	}

	// Testing if I still remember what I gave to Zaira
	@RequestMapping("loop")
	public String testloop() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		return "save.jsp";
	}

}
