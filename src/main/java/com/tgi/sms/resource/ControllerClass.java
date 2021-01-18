package com.tgi.sms.resource;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.bean.NameBean;
import com.tgi.sms.dao.daoClass;
import com.tgi.sms.model.Department;
import com.tgi.sms.model.Student;
import com.tgi.sms.repository.DepartmentRepo;

@Controller
public class ControllerClass {

	@Autowired
	DepartmentRepo deptrepo;

	// Start of the application
	@RequestMapping("/home")
	public String h() {
		return "Main.jsp";
	}

	@RequestMapping("/img")
	public String img() {
		return "profile.jsp";
	}

	@RequestMapping("/profile")
	public String profile(NameBean bean, String filename) throws IOException {

		int in = filename.indexOf(".");
		String ext = filename.substring(in+1);
		String name = filename.substring(0, in);
		BufferedImage image = null;
		System.out.println(name);
		System.out.println(ext);


		String path = "C:\\Users\\Master\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\SMS\\src\\main\\webapp\\images\\";
		try {
			// Creating an object of a file
			File testfile = new File(path+name+"."+ext);
			if (testfile.createNewFile()) {
				System.out.println("File created: " + testfile.getName());
				System.out.println("Absolute path: " + testfile.getAbsolutePath());
				try {
					image = ImageIO.read(testfile);
					System.out.println("Image added");
				}catch (IOException e) {
					System.out.println("An error occurred CREATING THE IMAGE.");
					e.printStackTrace();
				}
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return "save.jsp";
	}

	@RequestMapping("/testcheckbox")
	public ModelAndView testcheck() {
		ModelAndView model = new ModelAndView("testcheckbox.jsp");
		List<Department> dept = deptrepo.findAll();
		List<DepartmentBean> bean = new ArrayList<DepartmentBean>();
		for (Department d : dept) {
			DepartmentBean dob = new DepartmentBean();
			dob.setDepartmentName(d.getDepartmentName());
			dob.setDepartmentId(d.getDepartmentId());
			bean.add(dob);
		}
		model.addObject("dept", bean);
		return model;
	}

	// Test function from daoClass
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
