package com.tgi.sms.utils;

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

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml").addPackage("com.tgi.sms.model").addAnnotatedClass(Admin.class).addAnnotatedClass(Building.class).addAnnotatedClass(Course.class).addAnnotatedClass(Department.class).addAnnotatedClass(FeeLog.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Student.class).addAnnotatedClass(StudentFeeLog.class);
        	System.out.println("Hibernate Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
//        	This all can also be done with this single line, still to figure out what service registry is
//    		sessionFactory = new Configuration().configure().addPackage("com.tgi.sms.model").addAnnotatedClass(Admin.class).addAnnotatedClass(Building.class).addAnnotatedClass(Course.class).addAnnotatedClass(Department.class).addAnnotatedClass(FeeLog.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Student.class).addAnnotatedClass(StudentFeeLog.class).buildSessionFactory();

        	
            return sessionFactory;
		}
		catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) 
			sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
