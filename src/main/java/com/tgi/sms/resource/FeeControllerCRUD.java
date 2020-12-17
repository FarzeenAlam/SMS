package com.tgi.sms.resource;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.AddFeeBean;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.FeeLog;
import com.tgi.sms.model.Student;
import com.tgi.sms.model.StudentFeeLog;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.FeeLogRepo;
import com.tgi.sms.repository.StudentFeeLogRepo;
import com.tgi.sms.repository.StudentRepo;

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
	
	//Adding fee
	@RequestMapping("/addedfee")
	public String addFee(AddFeeBean fee) {
		String invoiceNo = "IN-" + System.currentTimeMillis();
		FeeLog feelog = convertBeanIntoEntity(fee);
		insertIntoStudentFeeLog(fee.getCoursesList(), invoiceNo);
		feerepo.save(feelog);
		return "feeadded.jsp";

	}

	//passing the courses list and invoice no from the previous function, 
	//to the student_fee_log table
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

	//Converting params received as bean to the entity object
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
	
	//Updating fee
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
			return "updated.jsp";
		} else
			return "datanotfound.jsp"; 
	}

	//Searching fee
	@RequestMapping("/searchingFee")
	public ModelAndView searchFee(int FeeId) {
		ModelAndView model = new ModelAndView("showFee.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if (feerepo.findById(FeeId).isPresent()) {
			model.addObject("fee", feerepo.findById(FeeId));
			return model;
		} else
			return m;
	}
	
	//Deleting fee
	@RequestMapping("deletingFee")
	public String deletingFee(int FeeId) {
		if (feerepo.findById(FeeId).isPresent()) {
			feerepo.deleteById(FeeId);
			return "datadeleted.jsp";
		} else
			return "datanotfound.jsp";
	}
	
	//Finding fee record against invoice no
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
