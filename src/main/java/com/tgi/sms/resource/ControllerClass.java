package com.tgi.sms.resource;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchUpdateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.FeeLogDetailBean;
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

//date passed here and returned here
	@RequestMapping("/searchRecord")
	public ModelAndView searchReocord(String DateTime) throws ParseException {

		List<FeeLog> list = daoClass.findFeeRecordsAgainstSpecificDate(DateTime);
		System.out.println("List passed");

		List<FeeLogDetailBean> feedetail = new ArrayList<FeeLogDetailBean>();
	
		ModelAndView model = new ModelAndView("showdatedetails.jsp");

		
		for (FeeLog feelog : list) {
			Course course = checkingInvoice(feelog.getInvoiceId());
			String ctitle = course.getCourseTitle();
			FeeLogDetailBean bean = convertEntityIntoBean(feelog, ctitle);
			feedetail.add(bean);
			System.out.println("FEE DETAIL BEAN ON PRINT CHECK IN LOOP");
			System.out.println(bean);
		}

		System.out.println(feedetail);
		//ModelMap map = new ModelMap();
		//map.put("feedetail", feedetail);
		//model.addAllObjects(map);
		//model.addObject(map);
		model.addObject("feedetail", feedetail);
		return model;
	}

	private FeeLogDetailBean convertEntityIntoBean(FeeLog fee, String ctitle) {
		
		FeeLogDetailBean feelogdetail = new FeeLogDetailBean();
		feelogdetail.setStudentId(fee.getStudent().getStudentId());
		feelogdetail.setCourseTitle(ctitle);
		feelogdetail.setAmount(fee.getAmount());
		feelogdetail.setDateTime(fee.getDateTime());
		
		return feelogdetail;
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

	// test function from daoClasss
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
//		LocalDate spec = LocalDate.parse(DateTime);
		LocalTime truncated = LocalTime.now().truncatedTo(ChronoUnit.HOURS);
		System.out.println(today);
		System.out.println(now);
		System.out.println(truncated);

		return "save.jsp";
	}

}
