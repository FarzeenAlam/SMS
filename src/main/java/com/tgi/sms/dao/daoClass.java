package com.tgi.sms.dao;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.tgi.sms.bean.DepartmentBean;
import com.tgi.sms.bean.DisplayBean;
import com.tgi.sms.model.Admin;
import com.tgi.sms.model.Building;
import com.tgi.sms.model.Course;
import com.tgi.sms.model.Department;
import com.tgi.sms.model.FeeLog;
import com.tgi.sms.model.Instructor;
import com.tgi.sms.model.Student;
import com.tgi.sms.model.StudentFeeLog;
import com.tgi.sms.utils.ApplicationUtils;

@SuppressWarnings("deprecation")
public class daoClass {

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml").addPackage("com.tgi.sms.model").addAnnotatedClass(Admin.class)
					.addAnnotatedClass(Building.class).addAnnotatedClass(Course.class)
					.addAnnotatedClass(Department.class).addAnnotatedClass(FeeLog.class)
					.addAnnotatedClass(Instructor.class).addAnnotatedClass(Student.class)
					.addAnnotatedClass(StudentFeeLog.class);
			System.out.println("Hibernate Configuration loaded");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println("Hibernate serviceRegistry created");

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

//        	This all can also be done with this single line, still to figure out what service registry is
//    		sessionFactory = new Configuration().configure().addPackage("com.tgi.sms.model").addAnnotatedClass(Admin.class).addAnnotatedClass(Building.class).addAnnotatedClass(Course.class).addAnnotatedClass(Department.class).addAnnotatedClass(FeeLog.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Student.class).addAnnotatedClass(StudentFeeLog.class).buildSessionFactory();

			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();

		return sessionFactory;
	}

	public static Session returnSession() {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}

	public static void endSession() {
		sessionFactory.close();
	}

	public static java.util.List<FeeLog> findFeeRecordsAgainstSpecificDate(String DateTime) throws ParseException {

		LocalDate spec = LocalDate.parse(DateTime);
		Date date = java.sql.Date.valueOf(spec);

		Date end = ApplicationUtils.getEnd(date);
		Date start = ApplicationUtils.clearTime(date);

		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		System.out.println("Session opened");
		Query q = session.createQuery("from FeeLog where DateTime>= :start and DateTime<= :end");

		q.setParameter("start", start);
		q.setParameter("end", end);
		System.out.println("Query created");

		List<FeeLog> list = q.list();
		System.out.println("List returned");

		endSession();
		session.close();

		return list;
	}

	// Just testing if the query and session works with unique result
	public static Student findStudent(int StudentId) {

		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		System.out.println("Session opened");
		Query q = session.createQuery("from Student where StudentId= :StudentId");
		q.setParameter("StudentId", StudentId);

		Student stud = (Student) q.uniqueResult();
		return stud;
	}

	public static List<FeeLog> findFeeRecordsAgainstSpecificStudentId(List<Integer> ids) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		
		Query q = session.createQuery("from FeeLog where StudentId in (:StudentId)");
		q.setParameterList("StudentId", ids);
		
		List<FeeLog> list = q.list();
		System.out.println("List returned");

		endSession();
		session.close();

		return list;
	}

	public static List<Date> findLastFeeDate(List<FeeLog> list) {
		
		
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		return null;
	}

	public static Department findDepartmentId(String departmentName) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		Query q = session.createQuery("from Department where DepartmentName= :departmentName");
		q.setParameter("departmentName", departmentName);
		Department department = (Department) q.uniqueResult();
		endSession();
		session.close();
		return department;
	}

	public static List<Course> findCoursebyDeptId(int deptId) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		Query q = session.createQuery("from Course where department= :department");
		q.setParameter("department", deptId);
		List<Course> list = q.list();
		endSession();
		session.close();
		return list;
	}

	public static int getCourseId(String name) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		Query q = session.createQuery("from Course where CourseTitle= :CourseTitle");
		q.setParameter("CourseTitle", name);
		Course course = (Course) q.uniqueResult();
		int id = course.getCourseId();
		return id;
	}

	public static List<Student> getStudents(boolean status) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		Query q = session.createQuery("from Student where StudentStatus= :StudentStatus");
		q.setParameter("StudentStatus", status);
		List<Student> student = q.list();
		System.out.println("List created");
		return student;
	}

	public static boolean seacrhRecordFromFeelog(String checkinvoice) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		boolean invoice = false;

		Query q = session.createQuery("from StudentFeeLog where InvoiceId= :InvoiceId");
		q.setParameter("InvoiceId", checkinvoice);
		StudentFeeLog fee = (StudentFeeLog) q.uniqueResult();
		if(fee != null) {
			invoice = true;
		}
		return invoice;
	}

	public static int getDepartmentId(String name) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		Query q = session.createQuery("from Department where DepartmentName= :DepartmentName");
		q.setParameter("DepartmentName", name);
		Department dept = (Department) q.uniqueResult();
		int id = dept.getDepartmentId();
		return id;
	}

	public static Course getCoursebyName(String name) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		Query q = session.createQuery("from Course where CourseTitle= :CourseTitle");
		q.setParameter("CourseTitle", name);
		Course course = (Course) q.uniqueResult();
		return course;
	}

	public static Building findBuildingbyName(String buildingName) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Session opened");
		Query q = session.createQuery("from Building where BuildingName= :BuildingName");
		q.setParameter("BuildingName", buildingName);
		Building b = (Building) q.uniqueResult();
		return b;
	}

}
