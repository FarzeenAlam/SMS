package com.tgi.sms.resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.AddFeeBean;
import com.tgi.sms.model.Admin;
import com.tgi.sms.model.Building;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Department;
import com.tgi.sms.model.FeeLog;
import com.tgi.sms.model.Instructor;
import com.tgi.sms.model.Student;
import com.tgi.sms.model.StudentFeeLog;
import com.tgi.sms.repository.AdminRepo;
import com.tgi.sms.repository.BuildingRepo;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.DepartmentRepo;
import com.tgi.sms.repository.FeeLogRepo;
import com.tgi.sms.repository.InstructorRepo;
import com.tgi.sms.repository.StudentFeeLogRepo;
import com.tgi.sms.repository.StudentRepo;

@Controller
public class ControllerClass {

	@Autowired
	AdminRepo repo;

	@Autowired
	FeeLogRepo feerepo;

	@Autowired
	StudentRepo studrepo;

	@Autowired
	InstructorRepo instrepo;

	@Autowired
	BuildingRepo brepo;

	@Autowired
	CourseRepo crepo;

	@Autowired
	DepartmentRepo deptrepo;

	@Autowired
	StudentFeeLogRepo studentfeerepo;

	// start of the application
	@RequestMapping("/home")
	public String h() {
		return "Main.jsp";
	}

	@RequestMapping("/datesearch")
	public String datesearch() {
		return "dateentry.jsp";
	}

//	@SuppressWarnings("unlikely-arg-type")
//	@RequestMapping("/searchRecord")
//	public ModelAndView searchRecord(Timestamp DateTime) {
//		ModelAndView model = new ModelAndView("showdata.jsp");
//		ModelAndView m = new ModelAndView("nodata.jsp");
//		feerepo.findAll();
//		FeeLog f = feerepo.findByDateTime(DateTime);
//		if(feerepo.findByDateTime(DateTime).equals(feerepo.findAll())) {
//			model.addObject("date", feerepo.findByDateTime(DateTime));
//			return model;
//
//		}
//		else
//			return m;
//	}

	@RequestMapping("/searchRecord")
	public ModelAndView searchReocord(Timestamp DateTime) {
		// long tocheck = DateTime.getTime();
		ModelAndView model = new ModelAndView("showFee.jsp");
		List<FeeLog> f = feerepo.findAll();
		for (FeeLog i : f) {
			// long withcheck = i.getDateTime().getTime();
			// if(tocheck == withcheck) {
			if (i.getDateTime() == DateTime) {
				model.addObject("fee", feerepo.findById(i.getFeeId()));
				break;
			}
		}
		return model;
	}

	// As it's causing duplicate entries, let's ignore it for now
//	@RequestMapping("/studentadded")
//	public String studentadded(Student s) {
//		studrepo.save(s);
//		return "save.jsp";
//	}
//	
//	@RequestMapping("/teacheradded")
//	public String teacheradded(Instructor i) {
//		instrepo.save(i);
//		return "save.jsp";
//	}

	@RequestMapping("/check")
	public String check() {
		return "getinvoice.jsp";
	}

	@RequestMapping("/checkingInvoice")
	public ModelAndView checkingInvoice(String InvoiceId) {
		ModelAndView model = new ModelAndView("showFee.jsp");

		List<StudentFeeLog> f = studentfeerepo.findAll();
//		@SuppressWarnings("rawtypes")
//		List<String> list =new ArrayList();
//		if(f.size()>0) {
//			for(int i =0; i<f.size(); i++) {
//				list.add(f.get(i).getInvoiceId());
//			}
//		}
//		if(list.size()>0) {
//			for(int i = 0; i<list.size(); i++) {
//				if(list.get(i).equals(InvoiceId)) {
//					model.addObject("fee", studentfeerepo.findById(f.get(i).getStudentFeeLogId()));
//					System.out.println(list);
//				}
//					
//			}
//		}

		if(f.size()>0) {
			for(int i =0; i<f.size(); i++) {
				if(f.get(i) != null) {
					System.out.print("Working here 2");
					if((f.get(i).getInvoiceId()).equals(InvoiceId)) {
						StudentFeeLog fee =studentfeerepo.findById(f.get(i).getStudentFeeLogId()).orElse(null);
						model.addObject("fee", fee);
						System.out.print(fee);
						break;
					}
				}
			}
		}
		return model;
		
	}
}
