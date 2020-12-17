package com.tgi.sms.resource;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
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
import com.tgi.sms.utils.ApplicationUtils;

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
	public ModelAndView searchReocord(Date DateTime) {
		
		long endTime = ApplicationUtils.getEnd(DateTime);
		long startTime = ApplicationUtils.clearTime(DateTime);
		
		List<FeeLog> list = feerepo.findAll();
		
		ModelAndView model = new ModelAndView("showFee.jsp");
		

//		javax.persistence.Query query = session.createNativeQuery("select * from FeeLog where DateTime between startTime and endTime");
//		
//		SessionFactory sessionFactory = HibernateUtils.
//		Session session = sessionFactory.getCurrentSession();
//
//		org.hibernate.Transaction tx = session.beginTransaction();

		
		for(int i = 0; i < list.size(); i++) {
			Timestamp t = list.get(i).getDateTime();
			
				
			}
			if(t.equals(DateTime)) {
				FeeLog fee = list.get(i);
				model.addObject("fee", fee);
				System.out.println(fee);
			}
		}
		return model;
	}

	@RequestMapping("/test")
	public String checkDate() {
		FeeLog fee = feerepo.findById(19).orElse(null);
		System.out.print(fee.getDateTime());
		return "save.jsp";
	}


}
