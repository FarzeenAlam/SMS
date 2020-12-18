package com.tgi.sms.resource;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	// start of the application
	@RequestMapping("/home")
	public String h() {
		return "Main.jsp";
	}

	@RequestMapping("/datesearch")
	public String datesearch() {
		return "dateentry.jsp";
	}

	@RequestMapping("/searchRecord")
	public ModelAndView searchReocord(String DateTime) throws ParseException {

		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(DateTime);
		System.out.println(DateTime + "\t" + date);

		Date end = ApplicationUtils.getEnd(date);
		Date start = ApplicationUtils.clearTime(date);

		System.out.println(start);
		System.out.println(end);

		List<FeeLog> feelist = feerepo.findAll();
		List<Course> courselist = crepo.findAll();
		List<StudentFeeLog> studentfeelist = studentfeerepo.findAll();

		ModelAndView model = new ModelAndView("showdatedetails.jsp");

		for (int i = 0; i < feelist.size(); i++) {
			Timestamp time = feelist.get(i).getDateTime();
			Date checkdate = time;
			if (checkdate.equals(date)) {
//				if(end >= checkdate) {
				FeeLog feeLog = feelist.get(i);
				String invoice = feeLog.getInvoiceId();
				double amount = feeLog.getAmount();
				String tt = feeLog.getTransactionType();
				Course course = checkingInvoice(invoice);
				model.addObject("fee", amount);
				model.addObject("tt", tt);
				model.addObject("course", course);
				System.out.println("Worked");
//				}
//				else
//					System.out.println("Null");


			}
			else
				System.out.println("NULLLLLL");
		}
		return model;
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
