package com.tgi.sms.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


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

	
	@SuppressWarnings("deprecation")
	public static java.util.List<FeeLog> findFeeRecordsAgainstSpecificDate(String DateTime) throws ParseException{
		
		Date date = new Date(DateTime);
		//Timestamp date = ApplicationUtils.stringtoDate(DateTime);
		Timestamp time = new Timestamp(date.getTime());
		
	//	Date date = ApplicationUtils.stringtoDate(DateTime);
		
	//	Date date = DateTime;
	//	Timestamp end = ApplicationUtils.getEnd(date);
	//	Timestamp start = ApplicationUtils.clearTime(date);
		
//		String query = "from FeeLog where DateTime between :start and :end";
//		String hql = "from POJO as POJO where POJO.tradeDate between :date and :ceilDate"; 
		
//		SessionFactory sessionFactory = getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
		
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		System.out.println("Session opened");
		Query q = session.createQuery("from FeeLog fl where fl.DateTime>=:start and fl.DateTime<=:end");
		System.out.println("Query created");

	//	String id = "Cash";
	//	q.setDate("start", start);
	//	q.setDate("end", end);
	//	q.setParameter("id", end);
	//	q.setParameter("start", start);
	//	q.setParameter("end", end);
//		q.setDate("start", start);
//		q.setDate("end", end);

		List<FeeLog> list = q.list();
		System.out.println("List returned");
		
		return list;
		
//		Query query = getSession().createQuery(hql); 
//		// a date having timestamp part, 00:00:00.0, or missing completely
//		query.setParameter("date", date); 
//		// a date having timestamp part, 23:59:59.999
//		query.setParameter("ceilDate", ceilDate); 

	}
	
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
	
}
