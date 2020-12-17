package com.tgi.sms.resource;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.model.Course;
import com.tgi.sms.model.FeeLog;

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
		List<FeeLog> list = feerepo.findAll();
		for(int i = 0; i < list.size(); i++) {
			Timestamp t = list.get(i).getDateTime();
			if(t.equals(DateTime)) {
				FeeLog fee = list.get(i);
				model.addObject("fee", fee);
				System.out.println(fee);
			}
		}
		return model;
	}

	@RequestMapping("/check")
	public String check() {
		return "getinvoice.jsp";
	}

	@RequestMapping("/checkingInvoice")
	public ModelAndView checkingInvoice(String InvoiceId) {
		ModelAndView model = new ModelAndView("showFee.jsp");
		List<StudentFeeLog> list = studentfeerepo.findAll();
		for(int i = 0; i < list.size(); i++) {
			String tocheck = list.get(i).getInvoiceId();
			if(tocheck.equals(InvoiceId)) {
				StudentFeeLog fee = list.get(i);
				model.addObject("fee", fee);
				System.out.println(tocheck);
			}
				
		}
		return model;
	}

}
