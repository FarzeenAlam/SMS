package com.tgi.sms.resource;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgi.sms.model.Admin;
import com.tgi.sms.model.Building;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Department;
import com.tgi.sms.model.FeeLog;
import com.tgi.sms.model.Instructor;
import com.tgi.sms.model.Student;
import com.tgi.sms.repository.AdminRepo;
import com.tgi.sms.repository.BuildingRepo;
import com.tgi.sms.repository.CourseRepo;
import com.tgi.sms.repository.DepartmentRepo;
import com.tgi.sms.repository.FeeLogRepo;
import com.tgi.sms.repository.InstructorRepo;
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
	
	//start of the application
	@RequestMapping("/adminlogin")
	public String h() {
		return "Main.jsp";
	}
	
	//login and role will be checked here
	@RequestMapping("/login")
	public String Login(Admin admin) {
		String id = admin.getEmail();
		String pwd = admin.getPassword();
		if(repo.findById(id).isPresent()) {
			Admin ad = repo.findById(id).orElse(null);
			if(ad.getPassword().equals(pwd)) {
				if(ad.getAccountType().equals("Admin"))
					return "admin.jsp";
				else if(ad.getAccountType().equals("Student"))
					return "student1.jsp";
				else
					return "teacher.jsp";
			}
				
			else
				return "pwderror.jsp";
		}
		else
			return "wrongdata.jsp";
	}
	
	@RequestMapping("/datesearch")
	public String datesearch() {
		return "dateentry.jsp";
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("/searchRecord")
	public ModelAndView searchRecord(Timestamp DateTime) {
		ModelAndView model = new ModelAndView("showdata.jsp");
		ModelAndView m = new ModelAndView("nodata.jsp");
		feerepo.findAll();
		FeeLog f = feerepo.findByDateTime(DateTime);
		if(feerepo.findByDateTime(DateTime).equals(feerepo.findAll())) {
			model.addObject("date", feerepo.findByDateTime(DateTime));
			return model;

		}
		else
			return m;
	}
	
	//If choice is account handling
	@RequestMapping("/accounts")
	public String accounts() {
		return "admin1.jsp";
	}
	
	//returning the form to add an account
	@RequestMapping("/add")
	public String addAdmin() {
		return "addform.jsp";
	}
	
	//register the account
	@RequestMapping("/register")
	public String Register(Admin admin) {
		String id = admin.getEmail();
		String name = admin.getName();
		if(repo.findById(id).isPresent()) {
			return "error.jsp";
		}
		else
		{
			if(admin.getAccountType().equals("Admin")) {
				repo.save(admin);
				return "save.jsp";
				}
			else if(admin.getAccountType().equals("Student")) {
				Student s = new Student();
				s.setStudentName(name);
				studrepo.save(s);
				repo.save(admin);
				return "save.jsp";
				//return "studentinfo.jsp";
			}
			else {
				Instructor i = new Instructor();
				instrepo.save(i);
				repo.save(admin);
				return "save.jsp";
				//return "teacherinfo.jsp";
			}
			
		}
	}
	
	//As it's causing duplicate entries, let's ignore it for now
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
	
	@RequestMapping("/edit")
	public String edit() {
		return "editform.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Admin a) {
		String id = a.getEmail();
		if(repo.findById(id).isPresent()) {
		Admin newAdmin = repo.findById(a.getEmail()).orElse(null);
		newAdmin.setEmail(a.getEmail());
		newAdmin.setName(a.getName());
		newAdmin.setPassword(a.getPassword());
		newAdmin.setAccountType(a.getAccountType());
		repo.save(newAdmin);
		return "updated.jsp";
		}
		else
			return "nodata.jsp";
	}
	
	@RequestMapping("/search")
	public String search() {
		return "searchform.jsp";
	}
	
	@RequestMapping("/searching")
	public ModelAndView search(String Email) {
		ModelAndView model = new ModelAndView("show.jsp");
		ModelAndView m = new ModelAndView("nodata.jsp");
		if(repo.findById(Email).isPresent()) {
			model.addObject("admin", repo.findById(Email));
			return model;
		}
		else
			return m;
	}
	
	@RequestMapping("delete")
	public String deleting() {
		return "deleteform.jsp";
	}
	
	@RequestMapping("deleted")
	public String delete(String Email) {
		if(repo.findById(Email).isPresent()) {
			repo.deleteById(Email);
			return "deleted.jsp";
		}
		else
			return "nodata.jsp";
	}
	
	//If choice is information handling
	@RequestMapping("/information")
	public String information() {
		return "infoform.jsp";
	}
	
	@RequestMapping("/building")
	public String building() {
		return "building.jsp";
	}
	
	@RequestMapping("/addBlock")
	public String addBlock() {
		return "addBlock.jsp";
	}

	@RequestMapping("/addingBlock")
	public String addingBlock(Building b) {
		brepo.save(b);
		return "dataadded.jsp";
	}
	
	@RequestMapping("/editBlock")
	public String editBlock() {
		return "editBlock.jsp";
	}
	
	@RequestMapping("/editingBlock")
	public String editingBlock(Building b) {
		int id = b.getBuildingId();
		if(brepo.findById(id).isPresent()) {
			Building newb = brepo.findById(b.getBuildingId()).orElse(null);
			newb.setBuildingName(b.getBuildingName());
			newb.setDepartment(b.getDepartment());
			brepo.save(newb);
			return "updated.jsp";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/searchBlock")
	public String searchBlock() {
		return "searchBlock.jsp";
	}
	
	@RequestMapping("/searchingBlock")
	public ModelAndView searchingBlock(int BuildingId) {
		ModelAndView model = new ModelAndView("showBlock.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if(brepo.findById(BuildingId).isPresent()) {
			model.addObject("building", brepo.findById(BuildingId));
			return model;
		}
		else
			return m;
	}
	
	@RequestMapping("/deleteBlock")
	public String deleteBlock() {
		return "deleteBlock.jsp";
	}
	
	@RequestMapping("deletingBlock")
	public String deletingBlock(int BuildingId) {
		if(brepo.findById(BuildingId).isPresent()) {
			brepo.deleteById(BuildingId);
			return "datadeleted";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/course")
	public String course() {
		return "course.jsp";
	}
	
	@RequestMapping("/addCourse")
	public String addCourse() {
		return "addCourse.jsp";
	}
	
	@RequestMapping("/addingCourse")
	public String addingCourse(Course c) {
		crepo.save(c);
		return "dataadded.jsp";
	}
	
	@RequestMapping("/editCourse")
	public String editCourse() {
		return "editCourse.jsp";
	}
	
	@RequestMapping("/editingCourse")
	public String editingCourse(Course c) {
		int id = c.getCourseId();
		if(crepo.findById(id).isPresent()) {
			Course newc = crepo.findById(c.getCourseId()).orElse(null);
			newc.setCourseTitle(c.getCourseTitle());
			newc.setCreditHours(c.getCreditHours());
			newc.setDepartment(c.getDepartment());
			newc.setFeelog(c.getFeelog());
			crepo.save(c);
			return "updated.jsp";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/searchCourse")
	public String searchCourse() {
		return "searchCourse.jsp";
	}
	
	@RequestMapping("/searchingCourse")
	public ModelAndView searchingCourse(int CourseId) {
		ModelAndView model = new ModelAndView("showCourse.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if(crepo.findById(CourseId).isPresent()) {
			model.addObject("course", crepo.findById(CourseId));
			return model;
		}
		else
			return m;
	}
	
	@RequestMapping("/deleteCourse")
	public String deleteCourse() {
		return "deleteCourse.jsp";
	}
	
	@RequestMapping("/deletingCourse")
	public String deletingCourse(int CourseId) {
		if(crepo.findById(CourseId).isPresent()) {
			crepo.deleteById(CourseId);
			return "datadeleted";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/department")
	public String department() {
		return "department.jsp";
	}
	
	@RequestMapping("/addDepartment")
	public String addDepartment() {
		return "addDept.jsp";
	}
	
	@RequestMapping("/addingDepartment")
	public String addingDepartment(Department dept) {
		deptrepo.save(dept);
		return "deptadded.jsp";
	}
	
	@RequestMapping("/editDepartment")
	public String editDepartment() {
		return "editDept.jsp";
	}
	
	@RequestMapping("/editingDepartment")
	public String editingDepartment(Department d) {
		int id = d.getDepartmentId();
		if(deptrepo.findById(id).isPresent()) {
			Department newd = deptrepo.findById(d.getDepartmentId()).orElse(null);
			newd.setDepartmentName(d.getDepartmentName());
			deptrepo.save(d);
			return "updated.jsp";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/searchDepartment")
	public String searchDepartment() {
		return "searchDept.jsp";
	}
	
	@RequestMapping("/searchingDepartment")
	public ModelAndView searchingDepartment(int DepartmentId) {
		ModelAndView model = new ModelAndView("showDept.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if(deptrepo.findById(DepartmentId).isPresent()) {
			model.addObject("dept", deptrepo.findById(DepartmentId));
			return model;
		}
		else
			return m;
	}
	
	@RequestMapping("/deleteDepartment")
	public String deleteDepartment() {
		return "deleteDept.jsp";
	}
	
	@RequestMapping("/deletingDepartment")
	public String deletingDepartment(int DepartmentId) {
		if(deptrepo.findById(DepartmentId).isPresent()) {
			deptrepo.deleteById(DepartmentId);
			return "datadeleted";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/student")
	public String student() {
		return "studentinfo.jsp";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent() {
		return "addstudent.jsp";
	}
	
	@RequestMapping("/addingStudent")
	public String addingstudent(Student s) {
		studrepo.save(s);
		return "addstudent.jsp";
	}
	
	@RequestMapping("/editStudent")
	public String editStudent() {
		return "editstudent.jsp";
	}
	
	@RequestMapping("/editingStudentent")
	public String editingStudent(Student s) {
		int id = s.getStudentId();
		if(studrepo.findById(id).isPresent()) {
			Student news = studrepo.findById(s.getStudentId()).orElse(null);
			news.setStudentName(s.getStudentName());
			news.setDepartment(s.getDepartment());
			studrepo.save(s);
			return "updated.jsp";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/searchStudent")
	public String searchStudent() {
		return "searchstudent.jsp";
	}
	
	@RequestMapping("/searchingStudent")
	public ModelAndView searchingStudent(int StudentId) {
		ModelAndView model = new ModelAndView("showstudent.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if(studrepo.findById(StudentId).isPresent()) {
			model.addObject("dept", studrepo.findById(StudentId));
			return model;
		}
		else
			return m;
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent() {
		return "deletestudent.jsp";
	}
	
	@RequestMapping("/deletingStudent")
	public String deletingStudent(int StudentId) {
		if(studrepo.findById(StudentId).isPresent()) {
			studrepo.deleteById(StudentId);
			return "datadeleted";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/teacher")
	public String teacher() {
		return "teacher.jsp";
	}
	
	
	//Student Control
	@RequestMapping("/addFee")
	public String add() {
		return "addfee.jsp";
	}
	
	@RequestMapping("/addedfee")
	public String addFee(FeeLog fee) {
		fee.setDateTime(new Timestamp(System.currentTimeMillis()));
		//fee.getDateTime();
		feerepo.save(fee);
		return "feeadded.jsp";
	}
	
	@RequestMapping("/editFee")
	public String editFee() {
		return "editFee.jsp";
	}
	
	@RequestMapping("/updatefee")
	public String editFee(FeeLog fee) {
		int id = fee.getFeeId();
		if(feerepo.findById(id).isPresent()) {
			FeeLog newfee = feerepo.findById(fee.getFeeId()).orElse(null);
			newfee.setAmount(fee.getAmount());
			newfee.setTransactionType(fee.getTransactionType());
			newfee.setCourse(fee.getCourse());
			newfee.setStudent(fee.getStudent());
			newfee.setDateTime(new Timestamp(System.currentTimeMillis()));
			feerepo.save(newfee);
			return "updated.jsp";
		}
		else
			return "datanotfound.jsp";	
	}
	
	@RequestMapping("/searchFee")
	public String searchFee() {
		return "searchFee.jsp";
	}
	
	@RequestMapping("/searchingFee")
	public ModelAndView searchFee(int FeeId) {
		ModelAndView model = new ModelAndView("showFee.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if(feerepo.findById(FeeId).isPresent()) {
			model.addObject("fee", feerepo.findById(FeeId));
			return model;
		}
		else
			return m;
	}
	
	@RequestMapping("/deleteFee")
	public String deleteFee() {
		return "deleteFee.jsp";
	}
	
	@RequestMapping("deletingFee")
	public String deletingFee(int FeeId) {
		if(feerepo.findById(FeeId).isPresent()) {
			feerepo.deleteById(FeeId);
			return "datadeleted.jsp";
		}
		else
			return "datanotfound.jsp";
	}
	
	//Teacher Profile
	@RequestMapping("/addTeacher")
	public String addTeacher() {
		return "addTeacher.jsp";
	}
	
	@RequestMapping("/addingTeacher")
	public String addingTeacher(Instructor inst) {
		instrepo.save(inst);
		return "teacheradded.jsp";
	}
	
	@RequestMapping("/editTeacher")
	public String editTeacher() {
		return "editTeacher.jsp";
	}
	
	@RequestMapping("/editingTeacher")
	public String editingTeacher(Instructor inst) {
		int id = inst.getInstructorId();
		if(instrepo.findById(id).isPresent()) {
			Instructor newinst = instrepo.findById(inst.getInstructorId()).orElse(null);
			newinst.setInstructorName(inst.getInstructorName());
			newinst.setSalary(inst.getSalary());
			newinst.setDepartment(inst.getDepartment());
			instrepo.save(newinst);
			return "updated.jsp";
		}
		else
			return "datanotfound.jsp";
	}
	
	@RequestMapping("/searchTeacher")
	public String searchTeacher() {
		return "searchTeacher.jsp";
	}
	
	@RequestMapping("/searchingTeacher")
	public ModelAndView searchingTeacher(int InstructorId) {
		ModelAndView model = new ModelAndView("showTeacher.jsp");
		ModelAndView m = new ModelAndView("datanotfound.jsp");
		if(instrepo.findById(InstructorId).isPresent()){
			model.addObject("instructor", instrepo.findById(InstructorId));
			return model;
		}
		else
			return m;
	}
	
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher() {
		return "deleteTeacher.jsp";
	}
	
	@RequestMapping("/deletingTeacher")
	public String deletingTeacher(int InstructorId) {
		if(instrepo.findById(InstructorId).isPresent()) {
			instrepo.deleteById(InstructorId);
			return "datadeleted.jsp";
		}
		else
			return "datanotfound.jsp";
	}
	
}
