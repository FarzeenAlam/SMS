package com.tgi.sms.resource;

import java.sql.Timestamp;
import java.text.ParseException;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.dao.daoClass;
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
	
//	@Autowired
//	daoClass dao;

	// start of the application
	@RequestMapping("/home")
	public String h() {
		return "Main.jsp";
	}

	@RequestMapping("/datesearch")
	public String datesearch() {
		return "dateentry.jsp";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/searchRecord")
	public ModelAndView searchReocord(String DateTime) throws ParseException {
		
		List<FeeLog> list = daoClass.findFeeRecordsAgainstSpecificDate(DateTime);
		
		System.out.println("List passed");
		
		for (FeeLog feelog : list) {
			System.out.println(feelog.getFeeId());
			System.out.println(feelog.getAmount());
			System.out.println(feelog.getInvoiceId());
			System.out.println(feelog.getTransactionType());
			System.out.println(feelog.getDateTime());
		}
		
		
//		List<FeeLog> list = daoClass.findFeeRecordsAgainstSpecificDate(DateTime);
//
//		Date date = ApplicationUtils.stringtoDate(DateTime);
//
//		Date end = ApplicationUtils.getEnd(date);
//		Date start = ApplicationUtils.clearTime(date);
//
//		if (date.before(end))
//			System.out.println("End time compared");
//
//		if (date.after(start))
//			System.out.println("Start time compared");
//
//		System.out.println(start);
//		System.out.println(end);
//
//		long a = date.getTime();
//		long b = end.getTime();
//		long c = start.getTime();
//
//		if (a < b && a > c) {
//			System.out.println("Long check true");
//		} else
//			System.out.println("Long check false");
//
//		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		session.beginTransaction();

//		Transaction tx = session.beginTransaction();
//		Query query = session.createQuery("from FeeLog");
//		query.setDate("date", date);
//		query.setInteger("FeeId", 19);
		
//		List<FeeLog> list = query.list();
//
//		for (FeeLog feelog : list) {
//			System.out.println(feelog.getFeeId());
//			System.out.println(feelog.getAmount());
//			System.out.println(feelog.getInvoiceId());
//			System.out.println(feelog.getTransactionType());
//			System.out.println(feelog.getDateTime());
//		}
//		FeeLog fee = (FeeLog) query.uniqueResult();
//		System.out.println(fee.getAmount() + " " + fee.getTransactionType());

//		List<FeeLog> feelist = feerepo.findAll();
//		List<Course> courselist = crepo.findAll();
//		List<StudentFeeLog> studentfeelist = studentfeerepo.findAll();

		ModelAndView model = new ModelAndView("showdatedetails.jsp");

//		for (int i = 0; i < feelist.size(); i++) {
//			Timestamp time = feelist.get(i).getDateTime();
//			long chk = feelist.get(i).getDateTime().getTime();
//			Date checkdate = time;
//			long checklong = checkdate.getTime();
//			if (checklongvalues(chk, b)) {
//				FeeLog feeLog = feelist.get(i);
//				String invoice = feeLog.getInvoiceId();
//				double amount = feeLog.getAmount();
//				String tt = feeLog.getTransactionType();
//				Course course = checkingInvoice(invoice);
//				model.addObject("fee", amount);
//				model.addObject("tt", tt);
//				model.addObject("course", course);
//				System.out.println("Worked");
//			} else
//				System.out.println("NULLLLLL");
//		}

//		sessionFactory.close();
		return model;
	}

	@RequestMapping("/sStudent")
	private String searchingStudent(int StudentId) {
		Student student = daoClass.findStudent(StudentId);
		System.out.println(student);
		return "save.jsp";
	}
	
	private boolean checklongvalues(long checklong, long c) {

		if (checklong > c) {
			return true;
		} else
			return false;
	}

	public Course checkingInvoice(String InvoiceId) {
		Course course = null;
		List<StudentFeeLog> list = studentfeerepo.findAll();
		for (int i = 0; i < list.size(); i++) {
			String tocheck = list.get(i).getInvoiceId();
			if (tocheck.equals(InvoiceId)) {
				course = list.get(i).getCourse();
			}
		}
		return course;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/test")
	public String checking() {

		SessionFactory sessionFactory = daoClass.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		System.out.println("Session opened in test");


		String query = "from FeeLog";

//		Timestamp t = feerepo.findById(19).get().getDateTime();
		Query q = session.createQuery(query);
		
		FeeLog f = feerepo.findById(19).orElse(null);
		Timestamp t = f.getDateTime();
		
		String in = "IN-1608206777291";
		Query query1 = session.createQuery("from FeeLog where DateTime= :id");
		query1.setTimestamp("id", t);
		
//		FeeLog feelog = (FeeLog) query1.uniqueResult();
//		
//		System.out.println(feelog.getFeeId());
//		System.out.println(feelog.getAmount());
//		System.out.println(feelog.getInvoiceId());
//		System.out.println(feelog.getTransactionType());
//		System.out.println(feelog.getDateTime());
//		
		List<FeeLog> list = query1.list();

		for (FeeLog feelog : list) {
			System.out.println(feelog.getFeeId());
			System.out.println(feelog.getAmount());
			System.out.println(feelog.getInvoiceId());
			System.out.println(feelog.getTransactionType());
			System.out.println(feelog.getDateTime());
		}

		session.close();
		sessionFactory.close();

		return "save.jsp";

	}

//	private ModelAndView searchStudentCourse(int id) {
//		ModelAndView model = new ModelAndView("showFee.jsp");
//
//		List<Course> list = crepo.findAll();
//		for(int i = 0; i < list.size(); i++) {
//			Course course = list.get(i);
//			if(course.getStudent().getStudentId()==id) {
//				model.addObject("fee", course);
//
//			}
//		}
//		return model;
//	}

//	@RequestMapping("/test")
//	public String checkDate() {
//		FeeLog fee = feerepo.findById(19).orElse(null);
//		System.out.println(fee.getDateTime());
//		long end = ApplicationUtils.getEnd(fee.getDateTime());
//		long start = ApplicationUtils.clearTime(fee.getDateTime());
//		System.out.println(start);
//		Date date = fee.getDateTime();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		String strDate = formatter.format(date);
//		System.out.println(strDate);
//		System.out.print(end);
//		return "save.jsp";
//	}

}
