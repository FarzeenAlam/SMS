package com.tgi.sms.resource;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.AddFeeBean;
import com.tgi.sms.bean.CourseBean;
import com.tgi.sms.bean.DisplayBean;
import com.tgi.sms.bean.FeeLogDetailBean;
import com.tgi.sms.bean.StudentIDBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.FeeLog;
import com.tgi.sms.model.Student;
import com.tgi.sms.model.StudentCourses;
import com.tgi.sms.model.StudentFeeLog;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.FeeLogRepo;
import com.tgi.sms.repository.StudentCoursesRepo;
import com.tgi.sms.repository.StudentFeeLogRepo;
import com.tgi.sms.repository.StudentRepo;
import com.tgi.sms.utils.ApplicationUtils;

@Controller
public class FeeControllerCRUD {

	@Autowired
	CourseRepo crepo;

	@Autowired
	FeeLogRepo feerepo;

	@Autowired
	StudentRepo studrepo;

	@Autowired
	StudentFeeLogRepo studentfeerepo;
	
	@Autowired
	StudentCoursesRepo screpo;

	// Adding fee
	@RequestMapping("/addedfee")
	public String addFee(AddFeeBean fee,StudentIDBean bean) {
		String invoiceNo = "IN-" + System.currentTimeMillis();
		fee.setStudent(bean.getStudentId());
		FeeLog feelog = convertBeanIntoEntity(fee);
		if (feelog.getStudent() != null) {
			insertIntoStudentFeeLog(fee.getCoursesList(), invoiceNo);
			feerepo.save(feelog);
		}
		return "feeadded.jsp";

	}

	// passing the courses list and invoice no from the previous function,
	// to the student_fee_log table
	private void insertIntoStudentFeeLog(List<Integer> list, String invoiceNo) {
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					Course course = crepo.findById(list.get(i)).orElse(null);
					if (course != null) {
						studentfeerepo.save(new StudentFeeLog(invoiceNo, course));
					}
				}
			}
		}
	}

	// Converting params received as bean to the entity object
	private FeeLog convertBeanIntoEntity(AddFeeBean bean) {
		FeeLog feelog = new FeeLog();
		feelog.setDateTime(new Timestamp(System.currentTimeMillis()));
		feelog.setAmount(bean.getAmount());
		feelog.setTransactionType(bean.getTransactionType());
		feelog.setInvoiceId("IN-" + System.currentTimeMillis());
		Student student = (Student) studrepo.findById(bean.getStudent()).orElse(null);

		if (student != null)
			feelog.setStudent(student);
		return feelog;
	}

	// Updating fee
	@RequestMapping("/updatefee")
	public String editFee(FeeLog fee) {
		int id = fee.getFeeId();
		if (feerepo.findById(id).isPresent()) {
			FeeLog newfee = feerepo.findById(fee.getFeeId()).orElse(null);
			newfee.setAmount(fee.getAmount());
			newfee.setTransactionType(fee.getTransactionType());
			newfee.setDateTime(new Timestamp(System.currentTimeMillis()));
			newfee.setInvoiceId("IN-" + System.currentTimeMillis());
			feerepo.save(newfee);
			return "feeupdated.jsp";
		} else
			return "feenotfound.jsp";
	}

	// Searching fee
	// If choice is byID
	@RequestMapping("/searchingFeebyID")
	public ModelAndView searchFee(int FeeId) {
		ModelAndView model = new ModelAndView("showFee.jsp");
		ModelAndView m = new ModelAndView("feenotfound.jsp");
		if (feerepo.findById(FeeId).isPresent()) {
			model.addObject("fee", feerepo.findById(FeeId));
			return model;
		} else
			return m;
	}

	// If choice is byInvoice
	@RequestMapping("/checkingInvoice")
	public ModelAndView searchingbyInvoice(String InvoiceId) {
		ModelAndView model = new ModelAndView("showFee.jsp");
		ModelAndView m = new ModelAndView("feenotfound.jsp");
		List<StudentFeeLog> list = studentfeerepo.findAll();
		Course course = new Course();
		for (int i = 0; i < list.size(); i++) {
			String tocheck = list.get(i).getInvoiceId();
			if (tocheck.equals(InvoiceId)) {
				course = list.get(i).getCourse();
				model.addObject("fee", course);
			}
		}
		if (course.equals(null))
			return m;
		else
			return model;
	}

	// If choice is byDate
	// Date passed here and returned here
	@RequestMapping("/searchRecord")
	public ModelAndView searchReocord(String DateTime) throws ParseException {

		List<FeeLog> list = daoClass.findFeeRecordsAgainstSpecificDate(DateTime);
		System.out.println("List passed");
		List<FeeLogDetailBean> feedetail = new ArrayList<FeeLogDetailBean>();
		ModelAndView model = new ModelAndView("showdatedetails.jsp");
		ModelAndView m = new ModelAndView("feenotfound.jsp");

		for (FeeLog feelog : list) {
			Course course = checkingInvoice(feelog.getInvoiceId());
			String ctitle = course.getCourseTitle();
			FeeLogDetailBean bean = convertEntityIntoBean(feelog, ctitle);
			feedetail.add(bean);
			System.out.println("FEE DETAIL BEAN ON PRINT CHECK IN LOOP");
			System.out.println(bean);
		}
		System.out.println(feedetail);
		if (feedetail.isEmpty()) {
			return m;
		} else {
			model.addObject("feedetail", feedetail);
			return model;
		}
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
		Course course = new Course();
		List<StudentFeeLog> list = studentfeerepo.findAll();
		for (int i = 0; i < list.size(); i++) {
			String tocheck = list.get(i).getInvoiceId();
			if (tocheck.equals(InvoiceId)) {
				course = list.get(i).getCourse();
			}
		}
		return course;
	}

	// If choice is byStatus
	@RequestMapping("/viewstatus")
	public ModelAndView viewstatus(CourseBean bean) {
		ModelAndView model = new ModelAndView("viewstatus.jsp");
		ModelAndView m = new ModelAndView("feenotfound.jsp");

		boolean status = bean.isStudentStatus();
		String name = bean.getCourseTitle();
		int id = daoClass.getCourseId(name);
		System.out.println(id);
		System.out.println(name);
		System.out.println(status);
		List<Student> student = daoClass.getStudents(status);
		List<StudentCourses> sc = screpo.findAll();
		List<DisplayBean> display = new ArrayList<DisplayBean>();
		if(student != null) {
			for(int i = 0; i < student.size(); i++) {
				StudentCourses s = new StudentCourses();
				if(sc.size() > i) {
					if(sc.get(i).getStudentId() == student.get(i).getStudentId()) {
						s = sc.get(i);
						if(s.getCourseId() == id) {
							DisplayBean dis = new DisplayBean();
							dis.setStudentId(s.getStudentId());
							display.add(dis);
						}
					}
				}
			}
		}
		System.out.println(display);
		DisplayBean dbean = new DisplayBean();
		List<DisplayBean> finallist = new ArrayList<DisplayBean>();
		List<FeeLog> feeloglist = feerepo.findAll();
		if(display != null) {
			for (int i = 0; i < display.size(); i++) {
				DisplayBean d = display.get(i);
				int disid = d.getStudentId();
				for (FeeLog f : feeloglist) {
					if (f.getStudent().getStudentId() == disid) {
						System.out.println("From FEELOG");
						System.out.println(f);
						String checkinvoice = f.getInvoiceId();
						boolean existsinSFL = daoClass.seacrhRecordFromFeelog(checkinvoice);
						if (existsinSFL) {
							Timestamp dateinTS = feeloglist.get(i).getDateTime();
							Date expirydate = ApplicationUtils.getExpiryDate(dateinTS);
							System.out.println(expirydate);
							dbean.setStudentId(disid);
							dbean.setExpiry(expirydate);
							dbean.setLastFee(dateinTS);
							finallist.add(dbean);
						}
					}
				}
			}
		}
		System.out.println(finallist);

		if (finallist.isEmpty()) {
			return m;
		} else {
			model.addObject("display", finallist);
			return model;
		}
	}

	// Deleting fee
	@RequestMapping("deletingFee")
	public String deletingFee(int FeeId) {
		if (feerepo.findById(FeeId).isPresent()) {
			feerepo.deleteById(FeeId);
			return "feedeleted.jsp";
		} else
			return "feenotfound.jsp";
	}

}
