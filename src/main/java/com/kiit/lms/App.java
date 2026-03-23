package com.kiit.lms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiit.lms.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	//cfg.configure("hibernate.cfg.xml");
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();

    	System.out.println(factory.isClosed());  //false
    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction();
    	Student s1=new Student();
    	s1.setSname("Alice");
    	s1.setPer(98.5);
    	
    	Student s2=new Student();
    	s2.setSname("Ben");
    	s2.setPer(88.5);
    	
    	Student s3=new Student();
    	s3.setSname("Chris");
    	s3.setPer(78.5);
    	
    	session1.save(s1);	//insert into..
    	session1.save(s2);	
    	session1.save(s3);	
    	tx.commit();
    	session1.close();
    	factory.close();

    }
}
